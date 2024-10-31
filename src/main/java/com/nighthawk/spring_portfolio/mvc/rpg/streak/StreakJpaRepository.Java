package com.nighthawk.spring_portfolio.mvc.rpg.streak;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StreakJpaRepository extends JpaRepository<Streak, Long> {
    // Custom query methods for the Streak entity

    // Finds a list of streaks by user ID
    List<Streak> findByUserId(Long userId);

    // Finds an optional streak by user ID and max streak (if needed for specific use cases)
    Optional<Streak> findByUserIdAndMaxStreak(Long userId, int maxStreak);
}
