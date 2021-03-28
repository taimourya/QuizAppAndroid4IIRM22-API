package com.example.quiz.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionID;
    private String question;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private Set<Reponse> reponses = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reponseID")
    private Reponse reponseCorrect;

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(Set<Reponse> reponses) {
        this.reponses = reponses;
    }

    public Reponse getReponseCorrect() {
        return reponseCorrect;
    }

    public void setReponseCorrect(Reponse reponseCorrect) {
        this.reponseCorrect = reponseCorrect;
    }
}
