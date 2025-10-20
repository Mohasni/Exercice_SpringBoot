package com.exercice.exo1.controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteControlleur {
    @GetMapping("/api/notes/hello")
    public String message() {
        return "notes ok";
    }
}
