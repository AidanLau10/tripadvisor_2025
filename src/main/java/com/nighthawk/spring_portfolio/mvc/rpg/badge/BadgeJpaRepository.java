package com.nighthawk.spring_portfolio.mvc.rpg.badge;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nighthawk.spring_portfolio.mvc.rpg.player.Player;

public interface BadgeJpaRepository extends JpaRepository<Badge, Long> {
    List<Player> findByPlayerId(Long id);

    @Transactional
    void deleteByPlayerId(long id);
}

