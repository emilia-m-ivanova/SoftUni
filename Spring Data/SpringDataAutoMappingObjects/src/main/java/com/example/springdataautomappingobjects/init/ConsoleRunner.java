package com.example.springdataautomappingobjects.init;

import com.example.springdataautomappingobjects.dto.*;
import com.example.springdataautomappingobjects.entity.User;
import com.example.springdataautomappingobjects.service.GameService;
import com.example.springdataautomappingobjects.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService;
    private final GameService gameService;
    private User loggedUser = null;

    @Autowired
    public ConsoleRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            System.out.println("Enter command (empty line for exit)");
            String[] command = scanner.nextLine().split("\\|");
            switch (command[0]){
                case "RegisterUser":
                    System.out.println(registerUser(command));
                    break;
                case "LoginUser":
                    System.out.println(loginUser(command));
                    break;
                case "Logout":
                    System.out.println(logout());
                    break;
                case "AddGame":
                    System.out.println(addGame(command));
                    break;
                case "EditGame":
                    System.out.println(editGame(command));
                    break;
                case "DeleteGame":
                    System.out.println(deleteGame(command));
                    break;
                case "AllGames":
                    System.out.println(showAllGames());
                    break;
                case "DetailGame":
                    System.out.println(showDetails(command));
                    break;
                case "OwnedGames":
                    System.out.println(showMyGames());
                    break;
                case "":
                    return;
            }
        }
    }

    private String showMyGames() {
        if(loggedUser==null){
            return "To access your game collection you need to login first.";
        }
        return userService.getAllGamesByOwner(loggedUser)
                .stream().map(UserGameDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String showDetails(String[] command) {
        GameDetailsDto gameDetails = gameService.getGameDetails(command[1]);
        if(gameDetails == null){
            return "No games available with the given title";
        }
        return gameDetails.toString();
    }

    private String showAllGames() {
        return gameService.getAllGamesOverview()
                .stream().map(GameOverViewDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String editGame(String[] command) {
        if(loggedUser == null || !loggedUser.isAdmin()){
            return "Only admins can add games to the catalog";
        }
        Long id = Long.valueOf(command[1]);
        Map<String,String> properties = new HashMap<>();
        for (int i = 2; i < command.length; i++) {
            String[] property = command[i].split("=");
            properties.put(property[0],property[1]);
        }
        return gameService.editGame(id,properties);
    }

    private String deleteGame(String[] command) {
        if(loggedUser == null || !loggedUser.isAdmin()){
            return "Only admins can add games to the catalog";
        }
        Long id = Long.valueOf(command[1]);
        return gameService.deleteGame(id);
    }

    private String addGame(String[] command) {
        if(loggedUser == null || !loggedUser.isAdmin()){
            return "Only admins can add games to the catalog";
        }
        String title = command[1];
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(command[2]));
        Double size = Double.parseDouble(command[3]);
        String trailer = command[4];
        String thumbnail = command[5];
        String description = command[6];
        String releaseDate = command[7];
        return gameService.addGame(new AddGameDto(title,price,size,trailer,thumbnail,description,releaseDate));
    }

    private String logout() {
        if (loggedUser == null) {
            return "No user is currently logged in";
        }
        loggedUser = null;
        return "Successfully logged out";
    }

    private String loginUser(String[] command) {
        String email = command[1];
        String password = command[2];
        LoginUserDto loginUserDto = new LoginUserDto(email,password);
        User user = userService.loginUser(loginUserDto);
        if(user == null){
            return "Wrong username or password";
        }
        loggedUser = user;
        return "Successfully logged in";
    }

    private String registerUser(String[] command) {
        String email = command[1];
        String password = command[2];
        String confirmPassword = command[3];
        String fullName = command[4];
        if(!password.equals(confirmPassword)){
            return "Passwords don't match";
        }
        return userService.register(new RegisterUserDto(email,password,confirmPassword,fullName));
    }
}
