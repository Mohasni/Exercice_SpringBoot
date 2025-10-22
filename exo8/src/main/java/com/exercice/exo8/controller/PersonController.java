package com.exercice.exo8.controller;

import com.exercice.exo8.model.Person;
import com.exercice.exo8.model.PersonDTO;
import com.exercice.exo8.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public Page<PersonDTO> getPerson(Pageable pageable){
        return personService.getPerson(pageable);
    }

    @GetMapping("/{id}")
    public PersonDTO getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    @GetMapping("/search")
    public List<PersonDTO> getPersonByName(@RequestParam String name){
        return personService.getPersonByName(name);
    }

    @PostMapping
    public PersonDTO postPerson(@RequestBody PersonDTO personDTO){
        return personService.postPerson(personDTO);
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

