/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensi.ilsi.lsm.services;

import com.ensi.ilsi.lsm.entities.Book;
import com.ensi.ilsi.lsm.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amin
 */
@Service
@Transactional
public class BookService {
    private final Logger log = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(Book book) {
        log.debug("Request to create book : {}", book);
        return  this.bookRepository.save(
                        new Book(
                               book.getId(),
                               book.getCompteur(),
                               book.getIventoryNumber(),
                               book.getStatus(),
                               book.getEmprunts(),
                               book.getOeuvre()
                             
                            )
                );
    }

    public List<Book> findAll() {
        log.debug("Request to get all books");
        return this.bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Book> findById(Long id) {
        log.debug("Request to get book : {}", id);
        return this.bookRepository.findById(id);
    }
    
    public void delete(Long id) {
        log.debug("Request to delete book : {}", id);

        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find book with id " + id));

        this.bookRepository.delete(book);
    }

    
}
