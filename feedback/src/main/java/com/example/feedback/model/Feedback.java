package com.example.feedback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank
    @Size(min=10)
    private String comment;

    @Min(0)
    @Max(5)
    private int rating;

//    @ManyToOne
//    private User user;
    @JsonProperty("user_id")
    private long userId;
}
