package springdatalab.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdatalab.models.entities.Seller;
import springdatalab.models.service.SellerServiceModel;
import springdatalab.repositories.SellerRepository;
import springdatalab.service.SellerService;
import springdatalab.service.ShopService;
import springdatalab.util.ValidationUtil;

import javax.validation.ConstraintViolation;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final ShopService shopService;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, ShopService shopService) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.shopService = shopService;
    }

    @Override
    public void addSeller(SellerServiceModel sellerServiceModel) {

        if (!this.validationUtil.isValid(sellerServiceModel)) {

            this.validationUtil
                    .violations(sellerServiceModel)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        Seller seller = this.modelMapper.map(sellerServiceModel, Seller.class);
        seller.setShop(shopService.findShopByName(sellerServiceModel.getShop()));

        this.sellerRepository.saveAndFlush(seller);
    }

    @Override
    public void addManager(String[] sellerParams, String[] managerParams) {
        Seller seller = this.sellerRepository
                .findByFirstNameAndLastName(sellerParams[0], sellerParams[1]);

        Seller manager = this.sellerRepository
                .findByFirstNameAndLastName(managerParams[0], managerParams[1]);

        seller.setManager(manager);

        sellerRepository.saveAndFlush(seller);
    }
}
