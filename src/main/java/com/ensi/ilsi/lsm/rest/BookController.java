/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.rest;

import com.ensi.ilsi.lsm.entities.Book;
import com.ensi.ilsi.lsm.services.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


/**
 *
 * @author Amin
 */
@RestController
@RequestMapping("/books")
public class BookController {
        @Autowired
        private BookService bookService;

        @GetMapping
        public List<Book> findAll() {
           return this.bookService.findAll();    
        }
        
        @GetMapping("/{id}")
        public Optional<Book> findById(@PathVariable Long id) {
            return this.bookService.findById(id);
        }
        
	@PostMapping
	public Book create(@RequestBody Book b) {
	   return this.bookService.create(b);
        }
        
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            this.bookService.delete(id);
        }

}
