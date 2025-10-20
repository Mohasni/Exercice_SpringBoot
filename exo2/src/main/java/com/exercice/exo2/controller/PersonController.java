package com.exercice.exo2.controller;

import com.exercice.exo2.model.Person;
import com.exercice.exo2.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping
    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Person> getPersonById(@PathVariable Long id){
        Person person = personRepository.findById(id).orElse(null);
        person.setId(id);
        return personRepository.findAll();
    }
    @PostMapping
    public Person postPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public Person putPerson(@PathVariable Long id,@RequestBody Person person){
        Person person1 = personRepository.findById(id).orElse(null);
        person.setId(person1.getId());
        return personRepository.save(person);
    }

    @DeleteMapping( "/{id}")
    public void deletPerson(@PathVariable Long id){
        personRepository.deleteById(id);
    }
}

