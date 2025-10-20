package com.exercice.exo1.repository;

import com.exercice.exo1.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
