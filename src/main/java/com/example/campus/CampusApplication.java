package com.example.campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CampusApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    public static void main(String[] args) {
        SpringApplication.run(CampusApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create admin if not exists
        Users admin = userRepo.findByEmailAndPassword("admin@anurag.edu", "admin123");
        if (admin == null) {
            Users a = new Users();
            a.setName("Administrator");
            a.setEmail("admin@anurag.edu");
            a.setPassword("admin123");
            a.setRole("ADMIN");
            userRepo.save(a);
            System.out.println("Admin user created: admin@anurag.edu / admin123");
        } else {
            System.out.println("Admin already exists");
        }
    }
}
