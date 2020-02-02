package pl.natalia.asocjacje.quiz;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass //pozwala na mapowanie klasy przez mapowanie dziecka
public class EntityBase { //stworzylismy nad klase, zeby tylko raz

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategia generowania
    private Long id;
}
