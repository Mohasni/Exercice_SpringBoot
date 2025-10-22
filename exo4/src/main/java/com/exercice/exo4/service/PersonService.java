package com.exercice.exo4.service;

import com.exercice.exo4.Error.PersonNotFoundExeption;
import com.exercice.exo4.Error.PersonNotValidExeption;
import com.exercice.exo4.model.Person;
import com.exercice.exo4.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    public Person getPersonById(Long id){
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundExeption("Person with id " + id + " not found"));
    }

    public Person postPerson(Person person){
        return personRepository.save(person);
    }

    public Person putPerson(Long id, Person person) throws PersonNotFoundExeption {
        Person person1 = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundExeption("Person with id " + id + " not found"));
        person1.setName(person.getName());
        person1.setEmail(person.getEmail());
        return personRepository.save(person1);
    }

    public void deletPerson(Long id) throws PersonNotFoundExeption {
        personRepository.deleteById(id);
        throw new PersonNotFoundExeption("Person with id " + id + " not found");
    }
}
