package springdatalab.service;

import springdatalab.models.service.SellerServiceModel;

public interface SellerService {

    void addSeller(SellerServiceModel sellerServiceModel);

    void addManager(String[] sellerParams, String[] managerParams);
}
