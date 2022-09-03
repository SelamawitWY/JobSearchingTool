package miu.cs.cs544.selam.jobsearchingtool.interview.model;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version private int version;
    private String question;
    @Enumerated(EnumType.STRING)
    private QuestionStatusEnum status;

    public Question() {
    }
    public Question(String question, QuestionStatusEnum status) {
        this.question = question;
        this.status = status;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(QuestionStatusEnum status) {
        this.status = status;
    }
}
