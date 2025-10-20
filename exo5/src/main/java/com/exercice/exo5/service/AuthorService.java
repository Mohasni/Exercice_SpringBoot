package com.exercice.exo5.service;

import com.exercice.exo5.model.Author;
import com.exercice.exo5.model.Book;
import com.exercice.exo5.repository.AuthorRepository;
import com.exercice.exo5.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;
    private  BookRepository bookRepository;

    public List<Book> getBook(Long id){
        Author author = authorRepository.findById(id).orElse(null);
        return author.getBook();
    }

    public Author postAuthor(Author author){
        return authorRepository.save(author);
    }
}
