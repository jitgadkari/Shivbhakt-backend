package com.shivbhakt.shivbhakt.controller;

import com.shivbhakt.shivbhakt.payload.UserDto;
import com.shivbhakt.shivbhakt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto, @RequestParam String role){
       UserDto userDto1= this.userService.createUser(userDto,role);
       return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Integer userId,@RequestParam String role){
        UserDto userDto1=this.userService.updateUser(userDto,userId,role);
        return  new ResponseEntity<>(userDto1,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
        UserDto userDto=this.userService.getUser(userId);
        return  new ResponseEntity<>(userDto,HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUser(){
    List<UserDto> userDtos=this.userService.getAllUser();
    return  new ResponseEntity<>(userDtos,HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<UserDto>> getUserByEmail(@PathVariable String email){
        Optional<UserDto> userDto=this.userService.findByEmail(email);
        return  new ResponseEntity<>(userDto,HttpStatus.OK);
    }




}
