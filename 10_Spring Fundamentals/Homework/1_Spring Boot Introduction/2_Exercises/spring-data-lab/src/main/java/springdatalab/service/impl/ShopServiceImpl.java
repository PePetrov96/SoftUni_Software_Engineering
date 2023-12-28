package springdatalab.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdatalab.models.entities.Shop;
import springdatalab.models.service.ShopServiceModel;
import springdatalab.models.view.ProductViewModel;
import springdatalab.models.view.SellerViewModel;
import springdatalab.repositories.ShopRepository;
import springdatalab.service.ShopService;
import springdatalab.service.TownService;
import springdatalab.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper, ValidationUtil validationUtil, TownService townService) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public void addShop(ShopServiceModel shopServiceModel) {

        if (!this.validationUtil.isValid(shopServiceModel)) {

            this.validationUtil
                    .violations(shopServiceModel)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Shop shop = this.modelMapper.map(shopServiceModel, Shop.class);
        shop.setTown(this.townService.findTownByName(shopServiceModel.getTown()));

        this.shopRepository
                .saveAndFlush(shop);
    }

    @Override
    public Shop findShopByName(String name) {

        return this.shopRepository.findByName(name);
    }

    @Override
    public List<SellerViewModel> findAllSellersFromShop(String shopName) {
        return this.shopRepository
                .findByName(shopName)
                .getSellers()
                .stream()
                .map(seller -> this.modelMapper.map(seller, SellerViewModel.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<ProductViewModel> findAllProductsFromShop(String shopName) {

        return this.shopRepository
                .findByName(shopName)
                .getProducts()
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }
}
