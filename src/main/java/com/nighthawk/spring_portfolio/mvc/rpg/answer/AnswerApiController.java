package com.nighthawk.spring_portfolio.mvc.rpg.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nighthawk.spring_portfolio.mvc.rpg.player.Player;
import com.nighthawk.spring_portfolio.mvc.rpg.question.Question;

import lombok.Getter;



@RestController
@RequestMapping("/rpg_answer")
public class AnswerApiController {

    @Autowired
    private AnswerJpaRepository answerJpaRepository;

    @Getter 
    public static class AnswerDto {
        private String content;
        private Question question;
        private Player player;
        private Long chatScore; 
    }
    @PostMapping("/submitanswer") 
    public ResponseEntity<Answer> postAnswer(@RequestBody AnswerDto answerDto) {
        Answer answer = new Answer(answerDto.getContent(), answerDto.getQuestion(), answerDto.getPlayer(), answerDto.getChatScore());
        answerJpaRepository.save(answer);
        
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    
}
