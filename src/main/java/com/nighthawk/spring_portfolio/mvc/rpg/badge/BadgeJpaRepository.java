package com.nighthawk.spring_portfolio.mvc.rpg.badge;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeJpaRepository extends JpaRepository<Badge, Long> {
    Badge findByName(String name);
}