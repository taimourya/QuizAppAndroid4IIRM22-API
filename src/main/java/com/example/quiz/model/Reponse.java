package com.example.quiz.model;

import javax.persistence.*;

@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reponseID;
    private String reponse;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "questionID")
    private Question question;

    public Long getReponseID() {
        return reponseID;
    }

    public void setReponseID(Long reponseID) {
        this.reponseID = reponseID;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
