package exam.service.impl;

import exam.model.Shop;
import exam.model.Town;
import exam.model.dtos.ShopCreateDTO;
import exam.model.dtos.ShopCreateWrapper;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static exam.constants.Messages.*;
import static exam.constants.Paths.SHOPS_PATH;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository,
                           ModelMapper mapper, ValidationUtil validator) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder out = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(SHOPS_PATH))) {
            JAXBContext context = JAXBContext.newInstance(ShopCreateWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            ShopCreateWrapper shopCreateWrapper = (ShopCreateWrapper) unmarshaller.unmarshal(reader);

            for (ShopCreateDTO shopDTO : shopCreateWrapper.getShops()) {
                boolean isValid = this.validator.isValid(shopDTO);

                Optional<Town> town = this.townRepository.findTownByName(shopDTO.getTown().getName());

                if (this.shopRepository.existsByName(shopDTO.getName()) || town.isEmpty()) {
                    isValid = false;
                }

                if (isValid) {
                    out.append(String.format(SHOP_IMPORTED, shopDTO.getName(), shopDTO.getIncome()));

                    Shop shop = mapper.map(shopDTO, Shop.class);
                    shop.setTown(town.get());

                    this.shopRepository.saveAndFlush(shop);

                } else {
                    out.append(String.format(INVALID_SHOP));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();;
        }

        return out.toString().trim();
    }
}
