package pl.natalia.asocjacje.dto;


import lombok.Data;
import pl.natalia.asocjacje.quiz.EntityBase;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDto {

    private Long id;  // id naszego zapytania do bazy dlatego sami generujemy
    private String content;
    private List<String> option = new ArrayList<>();
    private String answer;

    public QuestionDto(String content) {
        this.content = content;
    }
}
