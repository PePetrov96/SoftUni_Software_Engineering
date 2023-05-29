package com.example.gamestore;

import com.example.gamestore.common.Commands;
import com.example.gamestore.model.Administrator;
import com.example.gamestore.model.BaseUser;
import com.example.gamestore.model.Game;
import com.example.gamestore.model.dtos.GameDto;
import com.example.gamestore.services.GameService;
import com.example.gamestore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Component
public class Main implements CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;
    private BaseUser loggedUser = null;
    private final Administrator administrator = null;
    private Set<Game> shoppingCart;

    @Autowired
    public Main(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.shoppingCart = new HashSet<>();
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Just automating the whole testing instead of typing command by command
        List<String> inputCommands = seedCommands();

        consoleReader(inputCommands);
    }

    private void consoleReader(List<String> inputCommands) throws IOException {
        for (String inputLine : inputCommands) {
            String[] input = inputLine.split("\\|");

            Commands command = Commands.valueOf(input[0]);
            String[] data = Arrays.stream(input).skip(1).toArray(String[]::new);

            switch (command) {
                case Logout:
                    logoutUser();
                    break;
                case RegisterUser:
                    registerUser(data);
                    break;
                case LoginUser:
                    loginUser(data);
                    break;
                case AddGame:
                    addGame(data);
                    break;
                case EditGame:
                    editGame(data);
                    break;
                case DeleteGame:
                    deleteGame(data);
                    break;
                case AllGames:
                    printAllGames();
                    break;
                case DetailGame:
                    printGames(data);
                    break;
                case AddItem:
                    addItem(data);
                    break;
                case RemoveItem:
                    removeItem(data);
                    break;
                case BuyItem:
                    buyItem();
                    break;
            }
        }
    }

    private void printAllGames() {
        List<GameDto> games = this.gameService.getAllGames();

        for (GameDto game : games) {
            System.out.printf("%s %.2f%n", game.getTitle(), game.getPrice());
        }
    }
    private void printGames(String[] data) {
        try {
            GameDto game = this.gameService.getGameByTitle(data[0]);
            System.out.println(game.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private void logoutUser() {
        if (loggedUser != null) {
            System.out.printf("User %s has logged out.%n", loggedUser.getFullName());
            loggedUser = null;
        } else {
            System.out.println("Cannot log out. No user was logged in.");
        }
    }
    private void registerUser(String[] data) {
        this.userService.create(data);
        if (administrator == null) {
            this.userService.findAdmin();
        }
    }
    private void loginUser(String[] data) {
        loggedUser = this.userService.findByUsernameAndPassword(data[0], data[1]);

        if (loggedUser == null) {
            System.out.println("Incorrect username / password.");
        } else {
            System.out.printf("User %s has logged in.%n", loggedUser.getFullName());
        }
    }
    private void addGame(String[] data) {
        if (checkPermission()) {
            try {
                this.gameService.create(data);
                System.out.printf("Added %s%n", data[0]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void editGame(String[] data) {
        if (checkPermission()) {
            String name = null;

            try {
                name = this.gameService.editGame(data);
                System.out.printf("Edited %s%n", name);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void deleteGame(String[] data) {
        if (checkPermission()) {
            String name;

            try {
                name = this.gameService.deleteGame(Long.parseLong(data[0]));
                System.out.printf("Deleted %s%n", name);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private boolean checkPermission() {
        if (loggedUser == null || !loggedUser.isAdministrator()) {
            System.out.println("User does not have permission for this action.");
            return false;
        } else {
            return true;
        }
    }
    private void addItem(String[] data){
        try {
            Game game = this.gameService.findGameByTitle(data[0]);

            if (this.shoppingCart.contains(game)) {
                System.out.printf("%s is already in the shipping cart%n", game.getTitle());
            } else {
                this.shoppingCart.add(game);
                System.out.printf("%s added to cart%n", game.getTitle());
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private void removeItem(String[] data){
        try {
            Game game = this.gameService.findGameByTitle(data[0]);

            if (this.shoppingCart.contains(game)) {
                this.shoppingCart.remove(game);
                System.out.printf("%s removed from cart%n", game.getTitle());
            } else {
                System.out.printf("%s was was not the shipping cart%n", game.getTitle());
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private void buyItem(){
        this.userService.buyGames(this.shoppingCart, loggedUser);
        this.shoppingCart.clear();
    }
    private List<String> seedCommands() {
        String inputLine1 = "RegisterUser|ivan@ivan.com|Ivan12|Ivan12|Ivan"; //"Ivan was registered as administrator"
        String inputLine2 = "RegisterUser|ivan@ivan.com|Ivan12|Ivan12|Ivan"; //"User with this email already exists"
        String inputLine3 = "RegisterUser|kiro@ivan.com|Kiro12|Kiro12|Kiro"; //"Kiro was registered"
        String inputLine4 = "RegisterUser|petko@ivan.com|Petko12|Petko12|Petko"; //"Petko was registered"
        String inputLine5 = "LoginUser|ivan@ivan.com|Ivan12"; //"Successfully logged in Ivan"
        String inputLine6 = "Logout"; //"User Ivan successfully logged out"
        String inputLine7 = "LoginUser|ivan@ivan.com|Ivan12"; //"Successfully logged in Ivan"
        String inputLine8 = "AddGame|Overwatch|100.00|15.5|FqnKB22pOC0|https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|Overwatch " +
                "is a team-based multiplayer online first-person shooter video game developed and published by Blizzard Entertainment.|24-05-2016"; //"Overwatch added"
        String inputLine9 = "AddGame|Diablo|120.00|125.5|FqnKB22pOC0|https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|Diablo " +
                "is a multiplayer online RPG video game developed and published by Blizzard Entertainment.|06-06-2023"; //"Diablo added"
        String inputLine10 = "AddGame|Warcraft|150.00|45.5|FqnKB22pOC0|https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|Warcraft " +
                "is a multiplayer online strategy video game developed and published by Blizzard Entertainment.|28-04-2022"; //"Warcraft added"
        String inputLine11 = "AddGame|Heartstone|20.00|27.5|FqnKB22pOC0|https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|Heartstone " +
                "is a multiplayer online card video game developed and published by Blizzard Entertainment.|05-12-2014"; //"Heartstone added"
        String inputLine12 = "EditGame|1|price=80.00|size=12.0"; //"Edited Overwatch"
        String inputLine13 = "DeleteGame|1"; //"Deleted Overwatch"
        String inputLine14 = "AllGames"; //*Prints a list of all the games*
        String inputLine15 = "DetailGame|Warcraft"; //*Prints Full details about Overwatch*
        String inputLine16 = "AddItem|Warcraft"; //Overwatch added to cart.
        String inputLine17 = "RemoveItem|Warcraft"; //Overwatch added to cart.
        String inputLine18 = "AddItem|Warcraft"; //Overwatch removed from cart.
        String inputLine19 = "BuyItem"; //Successfully bought games: -Overwatch

        List<String> inputCommands = new ArrayList<>();
        inputCommands.add(inputLine1);
        inputCommands.add(inputLine2);
        inputCommands.add(inputLine3);
        inputCommands.add(inputLine4);
        inputCommands.add(inputLine5);
        inputCommands.add(inputLine6);
        inputCommands.add(inputLine7);
        inputCommands.add(inputLine8);
        inputCommands.add(inputLine9);
        inputCommands.add(inputLine10);
        inputCommands.add(inputLine11);
        inputCommands.add(inputLine12);
        inputCommands.add(inputLine13);
        inputCommands.add(inputLine14);
        inputCommands.add(inputLine15);
        inputCommands.add(inputLine16);
        inputCommands.add(inputLine17);
        inputCommands.add(inputLine18);
        inputCommands.add(inputLine19);

        return inputCommands;
    }
}