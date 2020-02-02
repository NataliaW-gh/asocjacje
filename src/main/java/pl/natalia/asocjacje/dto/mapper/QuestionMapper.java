package pl.natalia.asocjacje.dto.mapper;

import org.springframework.stereotype.Component;
import pl.natalia.asocjacje.dto.QuestionDto;
import pl.natalia.asocjacje.quiz.Answer;
import pl.natalia.asocjacje.quiz.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper {

    public QuestionDto mapToQuestionDto(Question question){

       // nie jest beanem wiec musimy sami stworzyc
        QuestionDto questionDto = new QuestionDto(question.getContent());
        questionDto.setId(question.getId()); //bierzemy id z pytania

        List<Answer> answers = question.getAnswers();

        //answers - tylko tresc odpowiedzi "name" z answer bez flagi,
        //1 Sposób przy pomocy petli
        List<String> answerName = new ArrayList<>();
        for (int i = 0; i < answerName.size() ; i++) {
            answerName.add(answers.get(i).getName());
        }

        questionDto.setOption(answerName);

        //2 sposob przy pomocy strumienia Stream
        List<String> answerName2 = answers.stream()
                .map(x ->x.getName())
                .collect(Collectors.toList());

        questionDto.setOption(answerName2);


        // teraz potrzebujemy flagi
        String correctAnswer = "";  // zmienna poczatkowa do ifa
        for (int i = 0; i < answers.size() ; i++) {
            if (answers.get(i).isCorrect()){
               correctAnswer = answers.get(i).getName();
            }
        }
        questionDto.setAnswer(correctAnswer);

        return questionDto;
    }

    public  List<QuestionDto> mapToListQuestionDto(List<Question> questions){
        return  questions.stream()
                .map(question -> mapToQuestionDto(question))
                .collect(Collectors.toList());
    }

}
