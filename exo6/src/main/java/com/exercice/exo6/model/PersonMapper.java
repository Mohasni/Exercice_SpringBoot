package com.exercice.exo6.model;

public class PersonMapper {
    public static PersonDTO  toDTO(Person person){
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getEmail()
        );
    }
}
