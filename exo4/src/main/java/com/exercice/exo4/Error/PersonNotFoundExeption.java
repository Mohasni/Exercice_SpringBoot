package com.exercice.exo4.Error;

public class PersonNotFoundExeption extends RuntimeException {
    public PersonNotFoundExeption(String message) {
        super(message);
    }
}
