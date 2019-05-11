package com.example.usermetanit.controller;

import com.example.usermetanit.model.User;
import com.example.usermetanit.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userRepo.findById(id).get();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id) {
        User updateUser = userRepo.findById(id).get();
        updateUser.setAge(user.getAge());
        updateUser.setName(user.getName());
        return userRepo.save(updateUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepo.deleteById(id);
    }

}
