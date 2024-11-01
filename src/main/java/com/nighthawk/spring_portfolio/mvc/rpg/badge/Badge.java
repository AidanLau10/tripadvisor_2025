package com.nighthawk.spring_portfolio.mvc.rpg.badge;

import java.util.ArrayList;

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
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public static Badge createBadge(String name) {
        Badge badge = new Badge();
        badge.setName(name);

        return badge;
    }

    public static Badge[] init() {
        ArrayList<Badge> badges = new ArrayList<>();
    
        badges.add(createBadge("Badge 1"));

        
        return badges.toArray(new Badge[0]);
    }

    public static void main(String[] args) {
    
        Badge badges[] = init();

        for( Badge badge : badges) {
            System.out.println(badge);  
        }
    }
}