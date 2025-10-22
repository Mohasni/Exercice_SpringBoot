package com.exercice.exo4.controller;

import com.exercice.exo4.Error.PersonNotFoundExeption;
import com.exercice.exo4.Error.PersonNotValidExeption;
import com.exercice.exo4.model.Person;
import com.exercice.exo4.service.PersonService;
import jakarta.validation.Valid;
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
    public Person getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    @PostMapping
    public Person postPerson(@RequestBody @Valid Person person){
        try {
            personService.postPerson(person);
        }catch (PersonNotValidExeption e){
            System.out.println("Person with id not valid");
        }
        return personService.postPerson(person);
    }

    @PutMapping("/{id}")
    public Person putPerson(@PathVariable Long id, @RequestBody @Valid Person person) {
        return personService.putPerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletPerson(id);
        throw new PersonNotFoundExeption("Person not found");
    }
}

