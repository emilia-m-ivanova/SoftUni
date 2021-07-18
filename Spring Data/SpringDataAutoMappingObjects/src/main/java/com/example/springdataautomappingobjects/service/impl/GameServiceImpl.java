package com.example.springdataautomappingobjects.service.impl;

import com.example.springdataautomappingobjects.dto.AddGameDto;
import com.example.springdataautomappingobjects.dto.GameDetailsDto;
import com.example.springdataautomappingobjects.dto.GameOverViewDto;
import com.example.springdataautomappingobjects.dto.UserGameDto;
import com.example.springdataautomappingobjects.entity.Game;
import com.example.springdataautomappingobjects.entity.Order;
import com.example.springdataautomappingobjects.entity.User;
import com.example.springdataautomappingobjects.repository.GameRepository;
import com.example.springdataautomappingobjects.service.GameService;
import com.example.springdataautomappingobjects.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final ModelMapper modelMapper;
    private final GameRepository gameRepository;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(ModelMapper modelMapper, GameRepository gameRepository, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.gameRepository = gameRepository;
        this.validationUtil = validationUtil;
    }


    @Override
    public String addGame(AddGameDto addGameDto) {
        Game game = modelMapper.map(addGameDto, Game.class);
        LocalDate date = LocalDate.parse(
                addGameDto.getReleaseDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")
        );
        game.setReleaseDate(date);
        if (validationUtil.isValid(game)) {
            gameRepository.save(game);
            return "Added " + addGameDto.getTitle();
        }
        Set<ConstraintViolation<Game>> violations = validationUtil.violation(game);
        return String.join(System.lineSeparator(),
                violations.stream().map(v -> v.getMessage()).collect(Collectors.toSet()));
    }

    @Override
    @Transactional
    public String deleteGame(Long id) {
        Optional<Game> game = gameRepository.deleteGameById(id);
        if (game.isEmpty()) {
            return "Game with id " + id + " doesn't exist";
        }
        return "Deleted game with id " + id ;
    }

    @Override
    @Transactional
    public String editGame(Long id, Map<String, String> values) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isEmpty()) {
            return "Game with id " + id + " doesn't exist";
        }
        Game game = optionalGame.get();
        if (values.containsKey("title")) {
            game.setTitle(values.get("title"));
        }
        if (values.containsKey("trailer")) {
            game.setTrailer(values.get("trailer"));
        }

        if (values.containsKey("imageThumbnail")) {
            game.setImageThumbnail(values.get("imageThumbnail"));
        }

        if (values.containsKey("size")) {
            game.setSize(Double.valueOf(values.get("size")));
        }
        if (values.containsKey("price")) {
            game.setPrice(BigDecimal.valueOf(Double.parseDouble(values.get("price"))));
        }
        if (values.containsKey("description")) {
            game.setDescription(values.get("description"));
        }

        if (values.containsKey("releaseDate")) {
            LocalDate date = LocalDate.parse(
                    values.get("releaseDate"), DateTimeFormatter.ofPattern("dd-MM-yyyy")
            );
            game.setReleaseDate(date);
        }

        return "Edited " + game.getTitle();
    }

    @Override
    public List<GameOverViewDto> getAllGamesOverview() {
        return gameRepository.findAll()
                .stream()
                .map(e->modelMapper.map(e,GameOverViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GameDetailsDto getGameDetails(String name) {
        Optional<Game> byTitle = gameRepository.findByTitle(name);
        if(byTitle.isEmpty()){
            return null;
        }
        return modelMapper.map(byTitle.get(),GameDetailsDto.class);
    }

}
