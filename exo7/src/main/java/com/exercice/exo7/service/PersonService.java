package com.exercice.exo7.service;

import com.exercice.exo7.model.Person;
import com.exercice.exo7.model.PersonDTO;
import com.exercice.exo7.model.PersonMapper;
import com.exercice.exo7.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
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

    public PersonDTO postPerson(PersonDTO personDTO){
        Person person = PersonMapper.toEntity(personDTO);
        person = personRepository.save(person);
        return PersonMapper.toDTO(person);
    }

    public Person putPerson(Long id, Person person){
        Person person1 = personRepository.findById(id).orElse(null);
        person1.setName(person.getName());
        person1.setEmail(person.getEmail());
        return personRepository.save(person1);
    }

    public void deletPerson(Long id){
        personRepository.deleteById(id);
    }
}
