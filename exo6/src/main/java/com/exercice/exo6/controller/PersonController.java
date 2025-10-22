package com.exercice.exo6.controller;

import com.exercice.exo6.model.Person;
import com.exercice.exo6.model.PersonDTO;
import com.exercice.exo6.repository.PersonRepository;
import com.exercice.exo6.service.PersonService;
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
    public List<PersonDTO> getPerson(){
        return personService.getPerson();
    }

    @GetMapping("/{id}")
    public PersonDTO getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }
    @PostMapping
    public PersonDTO postPerson(@RequestBody PersonDTO personDTO){
        return personService.postPerson(personDTO);
    }
    @PutMapping("/{id}")
    public PersonDTO putPerson(@PathVariable Long id,@RequestBody PersonDTO personDTO){
        return personService.putPerson(id, personDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletPerson(id);
    }
}

