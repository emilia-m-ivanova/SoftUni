package com.example.springdataautomappingobjects.service;

import com.example.springdataautomappingobjects.dto.AddGameDto;
import com.example.springdataautomappingobjects.dto.GameDetailsDto;
import com.example.springdataautomappingobjects.dto.GameOverViewDto;
import com.example.springdataautomappingobjects.dto.UserGameDto;
import com.example.springdataautomappingobjects.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface GameService {

    String addGame(AddGameDto addGameDto);

    String deleteGame(Long id);

    String editGame(Long id, Map<String,String> values);

    List<GameOverViewDto> getAllGamesOverview();

    GameDetailsDto getGameDetails(String name);

}
