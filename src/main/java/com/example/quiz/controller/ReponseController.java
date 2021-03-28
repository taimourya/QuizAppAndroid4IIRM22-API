package com.example.quiz.controller;

import com.example.quiz.dao.QuestionRepository;
import com.example.quiz.dao.ReponseRepository;
import com.example.quiz.model.Question;
import com.example.quiz.model.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReponseController {

    private ReponseRepository reponseRepository;
    private QuestionRepository questionRepository;

    @Autowired
    public ReponseController(ReponseRepository reponseRepository, QuestionRepository questionRepository) {
        this.reponseRepository = reponseRepository;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/reponses/{id}")
    public List<Reponse> getReponsesOfQuestions(@PathVariable Long id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if(questionOptional.isPresent()) {
            Question question = questionOptional.get();
            return (List<Reponse>) reponseRepository.getReponsesByQuestion(question);
        }
        return null;
    }

    @GetMapping("/reponse/{id}")
    public Reponse getReponse(@PathVariable Long id) {
        Optional<Reponse> reponseOptional = reponseRepository.findById(id);
        if(reponseOptional.isPresent()) {
            return  reponseOptional.get();
        }
        return null;
    }

    @PostMapping("/reponse/create")
    Reponse createQuestion(@RequestBody Reponse reponse) {

        return reponseRepository.save(reponse);
    }

}
