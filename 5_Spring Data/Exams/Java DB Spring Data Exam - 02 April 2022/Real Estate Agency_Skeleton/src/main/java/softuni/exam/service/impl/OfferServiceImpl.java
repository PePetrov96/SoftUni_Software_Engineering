package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferCreateDTO;
import softuni.exam.models.dto.wrappers.OfferWrapper;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constants.Messages.*;
import static softuni.exam.constants.Paths.OFFERS_PATH;
import static softuni.exam.models.entity.enums.ApartmentType.three_rooms;


@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper mapper;
    private final ValidationUtils validator;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository,
                            ApartmentRepository apartmentRepository, ModelMapper mapper, ValidationUtils validator) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder out = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(OFFERS_PATH))) {
            JAXBContext context = JAXBContext.newInstance(OfferWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            OfferWrapper offerWrapper = (OfferWrapper) unmarshaller.unmarshal(reader);

            for (OfferCreateDTO offerDTO : offerWrapper.getOffers()) {
                boolean isValid = this.validator.isValid(offerDTO);

                Optional<Agent> agent = this.agentRepository.findAgentByFirstName(offerDTO.getAgent().getName());
                Optional<Apartment> apartment = this.apartmentRepository.findById(offerDTO.getApartment().getId());

                if (agent.isEmpty() || apartment.isEmpty()) {
                    isValid = false;
                }

                if (isValid) {
                    out.append(String.format(IMPORT_OFFER, offerDTO.getPrice()));

                    Offer offer = new Offer(
                            offerDTO.getPrice(), //Price
                            LocalDate.parse(offerDTO.getPublishedOn(), DateTimeFormatter.ofPattern("dd/MM/yyyy")), //Parsed Date
                            agent.get(), //Agent
                            apartment.get()); //Apartment

                    this.offerRepository.saveAndFlush(offer);
                } else {
                    out.append(String.format(INVALID_OFFER));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toString().trim();
    }

    @Override
    public String exportOffers() {
        StringBuilder out = new StringBuilder();

        List<Offer> offerList = this.offerRepository
                .findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(three_rooms);

        for (Offer offer : offerList) {

            out.append(String.format(EXPORT_OFFER,
                    offer.getAgent().getFirstName(),                //firstName
                    offer.getAgent().getLastName(),                 //lastName
                    offer.getId(),                                  //offerId
                    offer.getApartment().getArea(),                 //area
                    offer.getApartment().getTown().getTownName(),   //townName
                    offer.getPrice()));                             //price
        }

        return out.toString().trim();
    }
}
