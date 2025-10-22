package com.exercice.exo8.service;

import com.exercice.exo8.model.Person;
import com.exercice.exo8.model.PersonDTO;
import com.exercice.exo8.model.PersonMapper;
import com.exercice.exo8.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public Page<PersonDTO> getPerson(Pageable pageable) {
        Page<Person> person = personRepository.findAll(pageable);
        return person.map(PersonMapper :: toDTO);
    }

    public PersonDTO getPersonById(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return PersonMapper.toDTO(person);
    }

    public List<PersonDTO> getPersonByName(String name){
        List<Person> person = personRepository.findByNameContainingIgnoreCase(name);
        return person.stream().map(PersonMapper :: toDTO).toList();
    }

    public PersonDTO postPerson(PersonDTO personDTO){
        Person person = PersonMapper.toEntity(personDTO);
        person = personRepository.save(person);
        return PersonMapper.toDTO(person);
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
