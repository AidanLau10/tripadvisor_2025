package com.nighthawk.spring_portfolio.mvc.rpg.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nighthawk.spring_portfolio.mvc.rpg.player.Player;
import com.nighthawk.spring_portfolio.mvc.rpg.player.PlayerJpaRepository;
import com.nighthawk.spring_portfolio.mvc.rpg.question.Question;
import com.nighthawk.spring_portfolio.mvc.rpg.question.QuestionJpaRepository;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;



@RestController
@RequestMapping("/rpg_answer")
public class AnswerApiController {

    // Load environment variables using dotenv
    private final Dotenv dotenv = Dotenv.load();
    private final String apiUrl = dotenv.get("API_URL");
    private final String apiKey = dotenv.get("API_KEY");

    @Autowired
    private AnswerJpaRepository answerJpaRepository;

    @Autowired
    private QuestionJpaRepository questionJpaRepository;

    @Autowired
    private PlayerJpaRepository playerJpaRepository;


    @Autowired
    private QuestionJpaRepository questionJpaRepository;

    @Autowired
    private PlayerJpaRepository playerJpaRepository;
    @Getter 
    public static class AnswerDto {
        private String content;
        private Long questionId;
        private Long playerId;
        private Long chatScore; 
    }
    @PostMapping("/submitanswer") 
    public ResponseEntity<Answer> postAnswer(@RequestBody AnswerDto answerDto) {
        Answer answer = new Answer(answerDto.getContent(), answerDto.getQuestion(), answerDto.getPlayer(), answerDto.getChatScore());
        answerJpaRepository.save(answer);
        
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    
}
