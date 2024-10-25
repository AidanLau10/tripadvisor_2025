package com.nighthawk.spring_portfolio.mvc.rpg.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionJpaRepository extends JpaRepository<Question, Long> {

    List<Question> findByTitle(String title);
}

