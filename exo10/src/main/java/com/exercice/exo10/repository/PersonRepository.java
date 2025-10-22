package com.exercice.exo10.repository;

import com.exercice.exo10.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
List<Person> findByNameContainingIgnoreCase(String name);
}