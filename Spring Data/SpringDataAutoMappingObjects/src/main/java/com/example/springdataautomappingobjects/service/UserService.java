package com.example.springdataautomappingobjects.service;

import com.example.springdataautomappingobjects.dto.LoginUserDto;
import com.example.springdataautomappingobjects.dto.RegisterUserDto;
import com.example.springdataautomappingobjects.dto.UserGameDto;
import com.example.springdataautomappingobjects.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    String register(RegisterUserDto registerUserDto);
    User loginUser(LoginUserDto loginUserDto);
    List<UserGameDto> getAllGamesByOwner(User user);
}
