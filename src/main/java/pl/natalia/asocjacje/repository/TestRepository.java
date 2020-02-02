package pl.natalia.asocjacje.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.natalia.asocjacje.quiz.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {
}
