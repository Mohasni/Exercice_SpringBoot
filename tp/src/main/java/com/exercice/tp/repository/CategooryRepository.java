package com.exercice.tp.repository;

import com.exercice.tp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategooryRepository extends JpaRepository<Category, Long> {
}

