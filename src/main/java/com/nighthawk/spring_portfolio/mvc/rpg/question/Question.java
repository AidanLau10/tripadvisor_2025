package com.nighthawk.spring_portfolio.mvc.rpg.question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String content;

    // Define the relationship between Question and Badge
    @Column(unique = true, nullable = false)    
    private String badge_name;

    @Column(unique = true, nullable = false)    
    private Byte badge_icon;

    // Constructor
    public Question(String title, String content, String badge_name, Byte badge_icon) {
        this.title = title;
        this.content = content;
        this.badge_name = badge_name;
        this.badge_icon = badge_icon;
    }
        // Create a Question with the related Badge
        // questions.add(createQuestion("Unit 1 Popcorn Hack 1", "What is the output of the following code cell?", badge));
}
