package com.exercice.exo4.Error;

public class PersonNotValidExeption extends RuntimeException {
    public PersonNotValidExeption(String message) {
        super(message);
    }
}
