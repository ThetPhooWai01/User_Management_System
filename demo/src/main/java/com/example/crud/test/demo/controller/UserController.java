package com.example.crud.test.demo.controller;

import com.example.crud.test.demo.dto.UserDto;
import com.example.crud.test.demo.service.UserService;
import com.example.crud.test.demo.dto.UserServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public UserServiceResponse saveUser(@RequestBody UserDto userDto){
        return new UserServiceResponse("It is user adding....",userService.saveUser(userDto));
    }
    @GetMapping("/user/{id}")
    public UserServiceResponse getUser(@PathVariable("id") Long id){
        return new UserServiceResponse("It is user data....",userService.getUser(id));
    }

    @PutMapping("/user/{id}")
    public UserServiceResponse updateUser(@PathVariable("id")Long id,@RequestBody UserDto userDto){
        return new UserServiceResponse("Update Successful",userService.updateUser(id,userDto));
    }

    @DeleteMapping("/user/{id}")
    public UserServiceResponse deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return new UserServiceResponse("Delete Successful",null);
    }

    @GetMapping("/all")
    public UserServiceResponse getAllUsers(){
        return new UserServiceResponse("Success",userService.getAllUsers());
    }
    @GetMapping("/find")
    public UserServiceResponse findUser(@RequestParam("keyword") String keyword){
        return new UserServiceResponse("Success",userService.findUser(keyword));
    }
}
