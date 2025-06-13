package com.example.feedback.service;

import com.example.feedback.model.Feedback;
import com.example.feedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public double getAverageRating() {
        var ratings = feedbackRepository.findAll()
                .stream()
                .mapToInt(Feedback::getRating)
                .toArray();

        return ratings.length > 0
                ? (double) java.util.Arrays.stream(ratings).average().orElse(0.0)
                : 0.0;
    }
}
