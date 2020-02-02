package pl.natalia.asocjacje.quiz;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


// @NoArgsConstructor - 1 sposob zeby miec konstruktor jedno argumentowy
@Entity //Encja - może byc bean, konstruktor musi miec bezargumentowy
@Data
public class Test extends  EntityBase {

    private String name;

    public Test(String name) {
        this.name = name;
    }

    //2 sposob bezargumentowy konstruktor wymaganie zeby było beanem
    public  Test(){

    }
    @OneToMany (mappedBy = "test", cascade = CascadeType.ALL) //kaskadowość
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question){
        question.setTest(this);
        questions.add(question);
    }

}
