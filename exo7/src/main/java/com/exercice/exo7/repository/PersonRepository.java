package com.exercice.exo7.repository;

import com.exercice.exo7.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
