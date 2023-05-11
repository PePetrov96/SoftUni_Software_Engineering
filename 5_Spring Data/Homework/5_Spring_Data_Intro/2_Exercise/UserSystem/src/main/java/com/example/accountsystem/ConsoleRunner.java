package com.example.accountsystem;

import com.example.accountsystem.model.Country;
import com.example.accountsystem.model.Town;
import com.example.accountsystem.model.User;
import com.example.accountsystem.services.CountryService;
import com.example.accountsystem.services.TownService;
import com.example.accountsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;
    private final TownService townService;
    private final CountryService countryService;

    @Autowired
    public ConsoleRunner(UserService userService, TownService townService, CountryService countryService) {
        this.userService = userService;
        this.townService = townService;
        this.countryService = countryService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //registering some towns and cities
        registerTown("Plovdiv", "Bulgaria");
        registerTown("Varna", "Bulgaria");
        registerTown("Sofia", "Bulgaria");

        //registering some users
        registerUser("Peter", "Petrov",
                "PePetrov96", "abcABC123#$%",
                "PePetrov96@gmail.com", 26, "Plovdiv", "Sofia");

        registerUser("Ivan", "Ivanov",
                "IvIvanov95", "1Aa2Bb3Cc#$%",
                "IvIvanov95@gmail.com", 28, "Varna", "Sofia");

        //adding users to mutual friends lists
        addFriends("PePetrov96", "IvIvanov95");
    }

    private void registerUser(String firstName, String lastName, String username, String password,
                             String email, int age, String bornTown, String livingInTown) {

        Town bornTownReturn = this.townService.findByName(bornTown);
        Town livingTownReturn = this.townService.findByName(livingInTown);

        User user = new User(firstName, lastName, username, password, email, age);

        if (this.userService.findByUsername(username) == null) {
            this.userService.registerUser(user);

            user.setBornTown(bornTownReturn);
            user.setLivingInTown(livingTownReturn);
        }
    }

    private void registerTown(String townName, String countryName) {
        Town town = new Town(townName);

        if (this.townService.findByName(townName) == null) {
            this.townService.registerTown(town);
        } else {
            return;
        }

        Country country = new Country(countryName);

        if (this.countryService.findByName(countryName) == null) {
            this.countryService.registerCountry(country);
            town.setCountry(country);
        } else {
            Country country1 = this.countryService.findByName(countryName);
            town.setCountry(country1);
        }
    }

    private void addFriends(String username1, String username2) {
        User user1 = this.userService.findByUsername(username1);
        User user2 = this.userService.findByUsername(username2);

        //there is a specific reverse add that allows us to only add 1 user to the other in order to be mutual
        user1.addFriend(user2);
    }
}