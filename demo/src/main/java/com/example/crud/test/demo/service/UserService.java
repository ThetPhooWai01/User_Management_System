package com.example.crud.test.demo.service;

import com.example.crud.test.demo.dto.UserDto;
import com.example.crud.test.demo.entity.User;
import com.example.crud.test.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRep;

    public User saveUser(UserDto userDto){
        User user=new User();
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setDob(userDto.getDob());
        return userRep.save(user);

    }

    public User getUser(Long id){
        Optional<User> user= userRep.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }

    public User updateUser(Long id,UserDto userDto){
        Optional<User> user=userRep.findById(id);
        if(user.isPresent()){
            User user1=user.get();
            user1.setName(userDto.getName());
            user1.setAge(userDto.getAge());
            user1.setDob(userDto.getDob());
            return userRep.save(user1);
        }else{
            return null;
        }
    }

    public void  deleteUser(Long id){
        Optional<User> user=userRep.findById(id);
        if(user.isPresent()){
            User user1=user.get();
            userRep.delete(user1);
        }

    }

    public List<User> getAllUsers(){
        List<User> users = userRep.findAll();
        return users;
    }

    public List<User> findUser(String keyword){
        List<User> resultUsers = userRep.searchUser(keyword);
        return resultUsers;
    }
}

