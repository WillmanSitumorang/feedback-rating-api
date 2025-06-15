package com.example.feedback.dto;

import lombok.Data;

@Data
public class FeedbackRequest {
    private Long userId;
    private String comment;
    private int rating;
}
