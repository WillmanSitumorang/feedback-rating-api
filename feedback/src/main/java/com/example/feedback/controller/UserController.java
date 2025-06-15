package com.example.feedback.controller;

import com.example.feedback.model.Feedback;
import com.example.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.feedback.model.User;
// import com.example.feedback.service.FeedbackService;
import com.example.feedback.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;
     @Autowired
     private FeedbackService feedbackService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userService.getUser(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/feedbacks")
    public List<Feedback> getFeedbacksByUserId(@PathVariable Long id) {
        return feedbackService.getFeedbacksByUserId(id);
    }
}
