package com.example.feedback.controller;

import com.example.feedback.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings-summary")
public class RatingController {

    @Autowired
    private RatingService feedbackService;

    @GetMapping
    public double getAverageRating() {
        return feedbackService.getAverageRating();
    }
}
