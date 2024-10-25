package com.nighthawk.spring_portfolio.mvc.rpg.leaderboard;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nighthawk.spring_portfolio.mvc.rpg.player.Player;

public interface LeaderboardJpaRepository extends JpaRepository<Leaderboard, Long> {
    List<Player> findByPlayerId(Long id);

    @Transactional
    void deleteByPlayerId(long id);
}

