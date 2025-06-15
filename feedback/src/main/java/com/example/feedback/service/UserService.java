package com.example.feedback.service;

import com.example.feedback.model.User;
import com.example.feedback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepo.findById(id);
    }
}
