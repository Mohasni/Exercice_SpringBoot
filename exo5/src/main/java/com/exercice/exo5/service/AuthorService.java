package com.exercice.exo5.service;

import com.exercice.exo5.model.Author;
import com.exercice.exo5.model.Book;
import com.exercice.exo5.repository.AuthorRepository;
import com.exercice.exo5.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public List<Book> getBook(Long id){
        return bookRepository.findByAuthorId(id);
    }

    public Author postAuthor(Author author){
        return authorRepository.save(author);
    }
}
