package com.project.spring.web;

import com.project.spring.models.entity.UserRoleEntity;
import com.project.spring.models.entity.enums.UserRolesEnum;
import com.project.spring.repository.UserRoleRepository;
import com.project.spring.service.BrandService;
import com.project.spring.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandService brandService;
    private final ModelService modelService;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public DataInitializer(BrandService brandService, ModelService modelService, UserRoleRepository userRoleRepository) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) {
        if (!this.brandService.hasInitialized()) {
            this.brandService.importBrands();
        }

        if (!this.modelService.hasInitialized()) {
            this.modelService.importModels();
        }

        if (userRoleRepository.count() == 0) {
            //SAVE USER ROLE
            UserRoleEntity userRoleUSEREntity = new UserRoleEntity();

            userRoleUSEREntity.setRole(UserRolesEnum.USER);
            userRoleUSEREntity.setCreated(LocalDateTime.now());
            userRoleUSEREntity.setModified(LocalDateTime.now());

            userRoleRepository.save(userRoleUSEREntity);

            //SAVE ADMIN ROLE
            UserRoleEntity userRoleEntityADMIN = new UserRoleEntity();

            userRoleEntityADMIN.setRole(UserRolesEnum.ADMIN);
            userRoleEntityADMIN.setCreated(LocalDateTime.now());
            userRoleEntityADMIN.setModified(LocalDateTime.now());

            userRoleRepository.save(userRoleEntityADMIN);
        }
    }
}
