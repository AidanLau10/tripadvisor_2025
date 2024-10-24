package com.nighthawk.spring_portfolio.mvc.rpg.badge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/rpg_badge")
public class BadgeApiController {

    @Autowired
    private BadgeJpaRepository badgeJpaRepository;

    @GetMapping("/playerbadges/{playerId}")
    public ResponseEntity<List<Badge>> getBadges(@PathVariable Long playerId) {
        
        // Find badges by playerId
        List<Badge> badges = badgeJpaRepository.findByPlayerId(playerId);
        
        if (!badges.isEmpty()) {  // If badges exist for the player
            return new ResponseEntity<>(badges, HttpStatus.OK);
        }
        
        // If no badges are found for the given playerId
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
