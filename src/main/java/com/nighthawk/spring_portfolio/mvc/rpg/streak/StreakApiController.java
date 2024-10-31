package com.nighthawk.spring_portfolio.mvc.rpg.streak;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

/**
 * This class provides RESTful API endpoints for managing Streak entities.
 * It includes endpoints for creating, retrieving, and deleting Streak entities.
 */
@RestController
@RequestMapping("/rpg_streak")
public class StreakApiController {

    @Autowired
    private StreakJpaRepository streakJpaRepository;

    /**
     * Retrieves a Streak entity by its ID.
     *
     * @param id The ID of the Streak entity to retrieve.
     * @return A ResponseEntity containing the Streak entity if found, or a NOT_FOUND status if not found.
     */
    @GetMapping("/streak/{id}")
    public ResponseEntity<Streak> getStreak(@PathVariable long id) {
        Optional<Streak> optional = StreakJpaRepository.findById(id);
        if (optional.isPresent()) {
            Streak streak = optional.get();
            return new ResponseEntity<>(streak, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Retrieves all Streak entities in the database.
     * 
     * @return A ResponseEntity containing a list of Streak entities.
     */
    @GetMapping("/streak")
    public ResponseEntity<List<Streak>> getStreak() {
        return new ResponseEntity<>(StreakJpaRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Deletes a Streak entity by its ID.
     *
     * @param id The ID of the Streak entity to delete.
     * @return A ResponseEntity containing the Streak entity if deleted, or a NOT_FOUND status if not found.
     */
    @DeleteMapping("/streak/{id}")
    public ResponseEntity<Streak> deleteStreak(@PathVariable long id) {
        Optional<Streak> optional = StreakJpaRepository.findById(id);
        if (optional.isPresent()) {
            Streak streak = optional.get();
            StreakJpaRepository.deleteById(id);
            return new ResponseEntity<>(streak, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /* DTO (Data Transfer Object) to support POST request for postStreak method */
    @Getter
    public static class StreakDto {
        private Long userId;
        private int currentStreak;
        private int maxStreak;
        private String lastInteractionDate;
        private String lastResetDate;
    }

    /**
     * Creates a new Streak entity.
     * 
     * @param streakDto The DTO object containing streak data.
     * @return A ResponseEntity containing a success message if the Streak entity is created, or a BAD_REQUEST status if not created.
     */
    @PostMapping("/streak")
    public ResponseEntity<Object> postStreak(@RequestBody StreakDto streakDto) {
        // Create a new Streak entity using the provided DTO
        Streak streak = new Streak(streakDto.getUserId(), streakDto.getCurrentStreak(), streakDto.getMaxStreak(), streakDto.getLastInteractionDate(), streakDto.getLastResetDate());
        treakJpaRepository.save(streak);
        return new ResponseEntity<>("Streak created successfully", HttpStatus.CREATED);
    }

    /**
     * Search for Streaks by userId or maxStreak.
     * @param map of key-value (k, v), where the key is "term" and the value is the search term.
     * @return A ResponseEntity containing a list of Streak entities that match the search term.
     */
    @PostMapping("/streak/search")
    public ResponseEntity<Object> streakSearch(@RequestBody final Map<String, String> map) {
        String term = map.get("term");
        List<Streak> list = StreakJpaRepository.findByUserIdOrMaxStreak(Long.parseLong(term), Integer.parseInt(term));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
