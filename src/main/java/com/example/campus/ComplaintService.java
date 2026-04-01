package com.example.campus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository repo;

    public Complaint saveComplaint(Complaint c) {
        return repo.save(c);
    }

    public List<Complaint> getAll() {
        return repo.findAll();
    }

    public List<Complaint> getByEmail(String email) {
        return repo.findByStudentEmail(email);
    }

    public Complaint updateStatus(Long id, String status) {
        Complaint c = repo.findById(id).orElse(null);
        if (c != null) {
            c.setStatus(status);
            return repo.save(c);
        }
        return null;
    }
}
