package pl.natalia.asocjacje.quiz;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Question extends EntityBase {

    @JoinColumn(name = "test_id")
    @ManyToOne
    private Test test;

    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();


    public void addAnswer (Answer answer){
        answers.add(answer);
        answer.setQuestion(this);
    }

    public Question(String content){
        this.content = content;
    }

}
