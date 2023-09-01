package com.shivbhakt.shivbhakt.service;

import com.shivbhakt.shivbhakt.payload.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public UserDto createUser(UserDto userDto,String role);

    public UserDto updateUser(UserDto userDto,Integer userId,String role);

    public  UserDto getUser(Integer userId);

    public List<UserDto> getAllUser();

    public Optional<UserDto> findByEmail(String email);

}
