package com.resellerapp.config;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.model.enums.ConditionName;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.modelmapper.ModelMapper;

@Configuration
@EnableTransactionManagement
public class ApplicationBeanConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    //Initialize some entities in the DB, when we start the application
    @Bean
    public CommandLineRunner commandLineRunner (UserRepository userRepository,
            OfferRepository offerRepository, ConditionRepository conditionRepository) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return args -> {
            if (conditionRepository.count() == 0) {
                for (ConditionName conditionName : ConditionName.values()) {
                    Condition condition = new Condition();

                    condition.setConditionName(conditionName);
                    condition.setDescription();

                    conditionRepository.save(condition);
                }
            }

            if (userRepository.count() == 0) {
                User user1 = new User();

                user1.setUsername("admin");
                user1.setPassword(passwordEncoder.encode("admin"));
                user1.setEmail("admin@admin.com");

                userRepository.save(user1);

                User user2 = new User();

                user2.setUsername("user");
                user2.setPassword(passwordEncoder.encode("user"));
                user2.setEmail("user@user.com");

                userRepository.save(user2);
            }

            if (offerRepository.count() == 0) {
                Offer offer = new Offer();

                offer.setDescription("Some item");
                offer.setPrice(100.00);
                offer.setCondition(conditionRepository.getById(1L));

                User seller = userRepository.getById(1L);
                User buyer = userRepository.getById(2L);

                offer.setSeller(seller);
                offer.setBuyer(buyer);

                offerRepository.save(offer);

                Offer offer2 = new Offer();

                offer2.setDescription("Some other item");
                offer2.setPrice(150.00);
                offer2.setCondition(conditionRepository.getById(2L));

                offer2.setSeller(buyer);
                offer2.setBuyer(seller);

                offerRepository.save(offer2);
            }
        };
    }


}
