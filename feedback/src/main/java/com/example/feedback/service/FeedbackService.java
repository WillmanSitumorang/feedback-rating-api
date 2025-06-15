package com.example.feedback.service;

import com.example.feedback.dto.FeedbackRequest;
import com.example.feedback.model.User;
import com.example.feedback.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.feedback.model.Feedback;
import com.example.feedback.repository.FeedbackRepository;
import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;

    public FeedbackService(FeedbackRepository feedbackRepository, UserRepository userRepository) {

        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
    }
    //get all feedbacks (get all)
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    //get feedback by id (get by id)
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found with id: " + id));
    }
    //send feedback (post)
    public Feedback sendFeedback(FeedbackRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setComment(request.getComment());
        feedback.setRating(request.getRating());

        return feedbackRepository.save(feedback);
    }
    //update feedback by id (put)
    public Feedback updateFeedback(Long id, Feedback feedbackDetails) {
        Feedback feedback = getFeedbackById(id);
        feedback.setComment(feedbackDetails.getComment());
        feedback.setRating(feedbackDetails.getRating());
        return feedbackRepository.save(feedback);
    }
    //delete feedback by id (delete)
    public void deleteFeedback(Long id) {
        Feedback feedback = getFeedbackById(id);
        feedbackRepository.delete(feedback);
    }

    public List<Feedback> getFeedbacksByUserId(Long userId) {
        return feedbackRepository.findByUserId(userId);
    }

}