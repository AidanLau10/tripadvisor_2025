package com.nighthawk.spring_portfolio.mvc.rpg.badge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface BadgeJpaRepository extends JpaRepository<Badge, Long> {


    List<Badge> findByPlayerId(Long playerId);
    
    @Transactional
    void deleteByPlayerId(long id);
}

