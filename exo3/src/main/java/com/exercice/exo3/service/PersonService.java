package com.exercice.exo3.service;

import com.exercice.exo3.model.Person;
import com.exercice.exo3.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    public List<Person> getPersonById(Long id){
        Person person = personRepository.findById(id).orElse(null);
        person.setId(id);
        return personRepository.findAll();
    }

    public Person postPerson(Person person){
        return personRepository.save(person);
    }

    public Person putPerson(Long id, Person person){
            Person person1 = personRepository.findById(id).orElse(null);
            person.setId(person1.getId());
            return personRepository.save(person);
    }

    public void deletPerson(Long id){
        personRepository.deleteById(id);
    }
}
