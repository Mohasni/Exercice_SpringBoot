package com.exercice.exo5.controller;

import com.exercice.exo5.model.Book;
import com.exercice.exo5.service.BookService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/api/books")
    public Book postBook(@RequestBody Book book){
        return bookService.postBook(book);
    }
}
