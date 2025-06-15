package com.example.feedback.controller;

import java.util.List;

import com.example.feedback.dto.FeedbackRequest;
import com.example.feedback.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedback.model.Feedback;
import com.example.feedback.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
@Validated
public class FeedbackController {
    private final FeedbackService feedbackService;
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    // Endpoint to get all feedbacks
    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }
    // Endpoint to get feedback by id
    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }
    // Endpoint to send feedback
    @PostMapping
    public Feedback sendFeedback(@RequestBody FeedbackRequest request) {
        return feedbackService.sendFeedback(request);
    }
    // Endpoint to update feedback by id
    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable Long id, @RequestBody Feedback feedbackDetails) {
        return feedbackService.updateFeedback(id, feedbackDetails);
    }
    // Endpoint to delete feedback by id
    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
}
