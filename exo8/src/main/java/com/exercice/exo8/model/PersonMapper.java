package com.exercice.exo8.model;

public class PersonMapper {
    public static PersonDTO  toDTO(Person person){
        return new PersonDTO(
                person.getName(),
                person.getEmail()
        );
    }

    public static Person toEntity(PersonDTO personDTO){
        return new Person(
                personDTO.getName(),
                personDTO.getEmail()
        );
    }
}
