package com.nighthawk.spring_portfolio.mvc.rpg.question;

import org.hibernate.mapping.List;

import com.nighthawk.spring_portfolio.mvc.rpg.badge.Badge;
import com.nighthawk.spring_portfolio.mvc.rpg.player.Player;
import com.nighthawk.spring_portfolio.mvc.rpg.player.PlayerCsClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "badge_id", referencedColumnName = "id", nullable = false)
    private Badge badge;

    // Constructor
    public Question(String title, String content, Badge badge) {
        this.title = title;
        this.content = content;
        this.badge = badge;
    }

    public static Player createPlayer(String name, String email, String password) {
        // By default, Spring Security expects roles to have a "ROLE_" prefix.
        return createPlayer(name, email, password, Arrays.asList("CLASS_CSSE"));
    }
    /** 2nd telescoping method to create a Person object with parameterized roles
     * @param csclasses 
     */
    public static Question createQuestion(String name, String email, String password, List<String> csclassNames) {
        Player player = new Player();
        player.setName(name);
        player.setEmail(email);
        player.setPassword(password);
    
        List<PlayerCsClass> csclasses = new ArrayList<>();
        for (String className : csclassNames) {
            csclasses.add(new PlayerCsClass(className));  // Ensure constructor exists
        }
        player.setCsclasses(csclasses);
    
        return player;
    }
        // Create a Question with the related Badge
        // questions.add(createQuestion("Unit 1 Popcorn Hack 1", "What is the output of the following code cell?", badge));
}
