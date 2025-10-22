package com.exercice.exo6.service;

import com.exercice.exo6.model.Person;
import com.exercice.exo6.model.PersonDTO;
import com.exercice.exo6.model.PersonMapper;
import com.exercice.exo6.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public List<PersonDTO> getPerson(){
        List<Person> person = personRepository.findAll();
        List<PersonDTO> personDTO = new ArrayList<>();
        for (Person p: person){
            PersonDTO personDTO1 = PersonMapper.toDTO(p);
            personDTO.add(personDTO1);
        }
        return personDTO;
    }

    public PersonDTO getPersonById(Long id){
        Person person = personRepository.findById(id).orElse(null);
        return PersonMapper.toDTO(person);
    }

    public PersonDTO postPerson(PersonDTO personDTO){
        Person person = PersonMapper.toEntity(personDTO);
        person = personRepository.save(person);
        return PersonMapper.toDTO(person);
    }

    public PersonDTO putPerson(Long id, PersonDTO personDTO){
        Person person1 = personRepository.findById(id).orElse(null);
        person1.setName(personDTO.getName());
        person1.setEmail(personDTO.getEmail());
        return PersonMapper.toDTO(personRepository.save(person1));
    }


    public void deletPerson(Long id){
        personRepository.deleteById(id);
    }
}
