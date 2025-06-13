package com.example.feedback.service;

import org.springframework.stereotype.Service;
import com.example.feedback.model.Feedback;
import com.example.feedback.repository.FeedbackRepository;
import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
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
    public Feedback sendFeedback(Feedback feedback) {
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

}