package com.shivbhakt.shivbhakt.serviceImpl;

import com.shivbhakt.shivbhakt.entity.Role;
import com.shivbhakt.shivbhakt.entity.User;
import com.shivbhakt.shivbhakt.payload.UserDto;
import com.shivbhakt.shivbhakt.repository.UserRepository;
import com.shivbhakt.shivbhakt.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto,String role) {
      User user=  this.modelMapper.map(userDto,User.class);
      user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
//      if(role == "ADMIN"){
//          Role admin=Role.ADMIN;
//          user.setRole(admin);
//      }else {
//          Role normal = Role.NORMAL;
//          user.setRole(normal);
//      }
        user.setRole(Role.valueOf(role));
      User updatedUser=  this.userRepository.save(user);
      UserDto userDto1= this.modelMapper.map(updatedUser,UserDto.class);
        return userDto1;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId,String role) {
        User user=this.userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found with this Id"+userId));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setRole(Role.valueOf(role));
        UserDto userDto1=this.modelMapper.map(user,UserDto.class);
        return userDto1;
    }

    @Override
    public UserDto getUser(Integer userId) {
        User user=this.userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found with this Id "+userId));
        UserDto userDto=this.modelMapper.map(user,UserDto.class);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList =this.userRepository.findAll();
        List<UserDto> userDtos=userList.stream().map(user -> this.modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
       Optional<User> user= this.userRepository.findByEmail(email);
       Optional<UserDto> userDto= Optional.ofNullable(this.modelMapper.map(user, UserDto.class));
        return userDto;
    }
}
