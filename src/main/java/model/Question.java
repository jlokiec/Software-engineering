package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pizzeria.dbo.question")
public class Question extends AbstractModel {
    private String question;

    public Question() {
    }

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
