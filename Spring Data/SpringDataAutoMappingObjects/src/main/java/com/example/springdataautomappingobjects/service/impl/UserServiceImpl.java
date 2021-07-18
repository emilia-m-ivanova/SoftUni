package com.example.springdataautomappingobjects.service.impl;

import com.example.springdataautomappingobjects.dto.LoginUserDto;
import com.example.springdataautomappingobjects.dto.RegisterUserDto;
import com.example.springdataautomappingobjects.dto.UserGameDto;
import com.example.springdataautomappingobjects.entity.User;
import com.example.springdataautomappingobjects.repository.UserRepository;
import com.example.springdataautomappingobjects.service.UserService;
import com.example.springdataautomappingobjects.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private UserRepository userRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
    }


    @Override
    public String register(RegisterUserDto registerUserDto) {
        User user = modelMapper.map(registerUserDto, User.class);
        List<User> all = userRepository.findAll();
        if(all.isEmpty()){
            user.setAdmin(true);
        }
        if(validationUtil.isValid(user)){

            userRepository.save(user);
            return registerUserDto.getFullName() + " was registered";
        }
        Set<ConstraintViolation<User>> violations = validationUtil.violation(user);
        return String.join(System.lineSeparator(),
                violations.stream().map(v->v.getMessage()).collect(Collectors.toSet()));
    }

    @Override
    public User loginUser(LoginUserDto loginUserDto) {
        return userRepository.findByEmailAndPassword(loginUserDto.getEmail(), loginUserDto.getPassword())
                .orElse(null);
    }

    @Override
    public List<UserGameDto> getAllGamesByOwner(User user) {
        return user.getGames()
                .stream()
                .map(e->modelMapper.map(e,UserGameDto.class))
                .collect(Collectors.toList());
    }
}
