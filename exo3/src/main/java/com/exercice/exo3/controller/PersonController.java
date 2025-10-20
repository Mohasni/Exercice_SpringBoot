package com.exercice.exo3.controller;

import com.exercice.exo3.model.Person;
import com.exercice.exo3.repository.PersonRepository;
import com.exercice.exo3.service.PersonService;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public List<Person> getPerson(){
        return personService.getPerson();
    }

    @GetMapping("/{id}")
    public List<Person> getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }
    @PostMapping
    public Person postPerson(@RequestBody Person person){
        return personService.postPerson(person);
    }
    @PutMapping("/{id}")
    public Person putPerson(@PathVariable Long id,@RequestBody Person person){
        return personService.putPerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletPerson(id);
    }
}

