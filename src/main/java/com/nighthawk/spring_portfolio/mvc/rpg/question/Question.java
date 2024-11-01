package com.nighthawk.spring_portfolio.mvc.rpg.question;



import java.util.ArrayList;

import com.nighthawk.spring_portfolio.mvc.rpg.badge.Badge;
import com.nighthawk.spring_portfolio.mvc.rpg.badge.BadgeJpaRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "badge_id", nullable = false)
    private Badge badge;

    @Column(nullable = false)
    private int points;

    /* 
    @Lob
    @Column(unique = true, nullable = true)    
    private byte[] badge_icon;
    */

    // Constructor
    public Question(String title, String content, Badge badge, int points) {
        this.title = title;
        this.content = content;
        this.badge = badge;
        this.points = points;
    }

    /* 
    public static byte[] loadImageAsByteArray(String imagePath) {
        try {
            Path path = Path.of(imagePath);
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    */
    public static Question createQuestion(String title, String content, Badge badge, int points) {
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        question.setBadge(badge);
        question.setPoints(points);

        return question;
    }

    Badge badge = badgeJpaRepository.findById(1L)  // assume badge ID is 1
                                     .orElseThrow(() -> new RuntimeException("Badge not found"));

    public static Question[] init() {
        ArrayList<Question> questions = new ArrayList<>();
        
        // byte[] badgeIcon = loadImageAsByteArray("path/to/your/image.png");
        questions.add(createQuestion("Unit 1 Popcorn Hack 1", "What is the output of the following code cell?", badge, 10000));
        return questions.toArray(new Question[0]);
    }
}
