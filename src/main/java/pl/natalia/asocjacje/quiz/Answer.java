package pl.natalia.asocjacje.quiz;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class Answer extends EntityBase{

    private String name;
    private boolean correct;

    public Answer(String name, boolean correct) {
        this.name = name;
        this.correct = correct;
    }

    @JoinColumn(name = "qustion_id")
    @ManyToOne
    private  Question question;

    //getter
    public  boolean isCorrect(){
        return correct;
    }

}
