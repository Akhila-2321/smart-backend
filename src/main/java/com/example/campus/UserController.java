package com.example.campus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public Users loginUser(@RequestBody Users user) {
        return service.loginUser(user.getEmail(), user.getPassword());
    }

    @GetMapping
    public List<Users> getUsers() {
        return service.getAllUsers();
    }
}
