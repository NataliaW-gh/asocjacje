package pl.natalia.asocjacje.dto.mapper;

import org.springframework.stereotype.Component;
import pl.natalia.asocjacje.dto.TestDto;
import pl.natalia.asocjacje.quiz.Test;


@Component
public class TestMapper {

    private  QuestionMapper questionMapper = new QuestionMapper();

    public TestDto mapToTestDto (Test test){
        TestDto testDto = new TestDto();


        testDto.setName(test.getName()); //mapy typ Test wiec mozzemy na nim name bo ma gettery
        testDto.setQuestion(questionMapper.mapToListQuestionDto(test.getQuestions()));

        return testDto;
    }

}
