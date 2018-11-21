/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.entities;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Amin
 */
@Entity
public class Oeuvre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Long id;
    
    @Column(name="book_name")
    private String bookName;
    
    @Column(name="ISBN")
    private String ISBN;
    
    @Column(name="cp")
    private int compteur;
    
    @Column(name="publisher")
    private String publisher;
    
    @Column(name="free_books")
    private int freeBooks;
    
    @OneToMany(mappedBy = "oeuvre", targetEntity = Book.class)
    private List<Book> books;
    
    @OneToMany(mappedBy = "oeuvre", targetEntity = Reservation.class)
    private List<Reservation> reservations;

    public Oeuvre(Long id, String bookName, String ISBN, String publisher, int freeBooks, List<Book> books, List<Reservation> reservations) {
        this.id = id;
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.freeBooks = freeBooks;
        this.books = books;
        this.reservations = reservations;
    }

    public Oeuvre() {
        // JPA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getFreeBooks() {
        return freeBooks;
    }

    public void setFreeBooks(int freeBooks) {
        this.freeBooks = freeBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    
    
    
}
