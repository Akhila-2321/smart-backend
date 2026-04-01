package com.example.campus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public Users registerUser(Users user) {
        // Students only (admin auto-created)
        user.setRole("STUDENT");
        return repo.save(user);
    }

    public Users loginUser(String email, String password) {
        try {
            return repo.findByEmailAndPassword(email, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Users> getAllUsers() {
        return repo.findAll();
    }
}
