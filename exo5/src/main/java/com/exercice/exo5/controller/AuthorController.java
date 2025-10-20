package com.exercice.exo5.controller;

import com.exercice.exo5.model.Author;
import com.exercice.exo5.model.Book;
import com.exercice.exo5.repository.AuthorRepository;
import com.exercice.exo5.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/api/authors/{id}/books")
    public List<Book> getBook(@PathVariable Long id){
        return authorService.getBook(id);
    }

    @PostMapping("/api/author")
    public Author postAuthor(@RequestBody Author author){
        return authorService.postAuthor(author);
    }
}
