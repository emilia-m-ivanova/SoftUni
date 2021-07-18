package com.example.springdataautomappingobjects.config;

import com.example.springdataautomappingobjects.dto.AddGameDto;
import com.example.springdataautomappingobjects.entity.Game;
import org.modelmapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<AddGameDto, Game> typeMap = modelMapper.createTypeMap(AddGameDto.class, Game.class);
        typeMap.addMapping(AddGameDto::getThumbnail, Game::setImageThumbnail);
        return modelMapper;
    }
}
