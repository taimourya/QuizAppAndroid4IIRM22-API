package com.example.quiz.dao;


import com.example.quiz.model.Question;
import com.example.quiz.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Long> {

    @Query("SELECT r FROM Reponse r WHERE r.question = ?1")
    public Collection<Reponse> getReponsesByQuestion(Question question);

}
