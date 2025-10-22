package com.exercice.exo5.service;

import com.exercice.exo5.model.Author;
import com.exercice.exo5.model.Book;
import com.exercice.exo5.repository.AuthorRepository;
import com.exercice.exo5.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Book postBook(Book book){
        Author author = authorRepository.findById(book.getAuthor().getId()).orElse(null);
        book.setAuthor(author);
        return bookRepository.save(book);
    }
}
