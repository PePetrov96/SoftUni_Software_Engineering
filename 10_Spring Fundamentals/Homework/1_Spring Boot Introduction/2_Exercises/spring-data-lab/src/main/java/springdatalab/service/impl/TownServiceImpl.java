package springdatalab.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdatalab.models.entities.Town;
import springdatalab.models.service.TownServiceModel;
import springdatalab.repositories.TownRepository;
import springdatalab.service.TownService;
import springdatalab.util.ValidationUtil;

import javax.validation.ConstraintViolation;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addTown(String townName) {
        TownServiceModel townServiceModel = new TownServiceModel();
        townServiceModel.setName(townName);

        if (!this.validationUtil.isValid(townServiceModel)) {

            this.validationUtil
                    .violations(townServiceModel)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            this.townRepository
                    .saveAndFlush(this.modelMapper
                            .map(townServiceModel, Town.class));

        }
    }

    @Override
    public Town findTownByName(String townName) {
        return this.townRepository
                .findByName(townName)
                .orElse(null);

    }
}
