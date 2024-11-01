package com.nighthawk.spring_portfolio.mvc.rpg.badge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nighthawk.spring_portfolio.mvc.rpg.player.Player;

public interface BadgeJpaRepository extends JpaRepository<Badge, Long> {
    List<Badge> findDistinctByQuestionsAnswersPlayer(Player player);
}