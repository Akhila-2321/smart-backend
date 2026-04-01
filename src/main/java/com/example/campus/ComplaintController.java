package com.example.campus;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin("*")
public class ComplaintController {

    @Autowired
    private ComplaintService service;

    @PostMapping
    public Complaint addComplaint(@RequestBody Complaint c) {
        return service.saveComplaint(c);
    }

    @GetMapping("/all")
    public List<Complaint> getAll() {
        return service.getAll();
    }

    @GetMapping("/user/{email}")
    public List<Complaint> getByUser(@PathVariable String email) {
        return service.getByEmail(email);
    }

    @PutMapping("/update/{id}")
    public Complaint update(@PathVariable Long id, @RequestBody Complaint c) {
        return service.updateStatus(id, c.getStatus());
    }
}
