package com.nighthawk.spring_portfolio.mvc.rpg.player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  PlayerClassJpaRepository extends JpaRepository<PlayerClass, Long> {
    PlayerClass findByName(String name);
}
