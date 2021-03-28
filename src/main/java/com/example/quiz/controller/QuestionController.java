package com.example.quiz.controller;

import com.example.quiz.dao.QuestionRepository;
import com.example.quiz.model.Question;
import com.example.quiz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/questions")
    List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/question/{id}")
    Question getQuestion(@PathVariable Long id) {
        Optional<Question> questionOpt = questionRepository.findById(id);
        if(questionOpt.isPresent()) {
            return  questionOpt.get();
        }
        return null;
    }


    @PostMapping("/question/create")
    Question createQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

}
