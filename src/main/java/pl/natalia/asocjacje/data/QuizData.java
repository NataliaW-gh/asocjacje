package pl.natalia.asocjacje.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.natalia.asocjacje.quiz.Answer;
import pl.natalia.asocjacje.quiz.Question;
import pl.natalia.asocjacje.quiz.Test;
import pl.natalia.asocjacje.repository.TestRepository;

@Component
public class QuizData implements CommandLineRunner {  //interfejs, który uruchamia się zawsze, kiedy wstaje nasza aplikacja, wymusza na nas metode run

    @Autowired
    TestRepository testRepository;

    @Override
    public void run(String... args) throws Exception{

        Test test = new Test("About everything");
        Question question = new Question("What is The Capital of Poland");
        question.addAnswer(new Answer("Warsaw",true));
        question.addAnswer(new Answer("Mumbai",false));
        question.addAnswer(new Answer("Kolkatta",false));

        Question question2 = new Question("Who is CEO of Tesla Motors?");
        question2.addAnswer(new Answer("Bill Gates",false));
        question2.addAnswer(new Answer("Steve Jobs",false));
        question2.addAnswer(new Answer("Elon Musk",true));


        Question question4 = new Question("Word's Longest River?");
        question4.addAnswer(new Answer("River Nile",true));
        question4.addAnswer(new Answer("River Amazon",false));
        question4.addAnswer(new Answer("River Godavari",false));

        test.addQuestion(question);
        test.addQuestion(question2);
//        test.addQuestion(question3);
        test.addQuestion(question4);

        testRepository.save(test); //za pomoce metody save dodalismy test do bazy danych
    }
}
