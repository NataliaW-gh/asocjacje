package pl.natalia.asocjacje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.natalia.asocjacje.dto.TestDto;
import pl.natalia.asocjacje.dto.mapper.TestMapper;
import pl.natalia.asocjacje.repository.TestRepository;

@RestController // żeby nasza klasa była kontrolerem, odowiedzia jest JSON
@CrossOrigin // odblokowuje zapytania z zewnatrz
@RequestMapping("/tests") //zapytanie ze sciezki /test trafia do tego controllera
public class TestController {

    @Autowired //wstrzykujemy zalezności beana, klasa musi być beanami, obiekty tej klasy zostana stworzone i usuniete przez Springa
    private TestMapper testMapper;

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/{id}") //odebrać reqest (GET) z przeglądarki {to co w klamrze to to identyczne co niżej)
    @ResponseBody
    public TestDto sayHello(@PathVariable Long id){
        return testMapper.mapToTestDto(testRepository.findById(id).get());
    }
}
