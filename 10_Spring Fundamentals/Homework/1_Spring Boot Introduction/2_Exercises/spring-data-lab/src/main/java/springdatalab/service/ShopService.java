package springdatalab.service;

import springdatalab.models.entities.Shop;
import springdatalab.models.service.ShopServiceModel;
import springdatalab.models.view.ProductViewModel;
import springdatalab.models.view.SellerViewModel;

import java.util.List;

public interface ShopService {

    void addShop(ShopServiceModel shopServiceModel);

    Shop findShopByName(String name);

    List<SellerViewModel> findAllSellersFromShop(String shopName);

    List<ProductViewModel> findAllProductsFromShop(String shopName);
}
