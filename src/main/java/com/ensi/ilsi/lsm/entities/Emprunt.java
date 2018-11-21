/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.ZonedDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Amin
 */
@Entity
public class Emprunt {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "emprunt_date")
    private ZonedDateTime EmpruntDate;
    
    @Column(name = "return_date")
    private ZonedDateTime ReturnDate;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference(value = "emp")
    private Member member;
    
    @ManyToOne
    private Book book;

    public Emprunt(Long id, ZonedDateTime EmpruntDate, ZonedDateTime ReturnDate, Member member, Book book) {
        this.id = id;
        this.EmpruntDate = EmpruntDate;
        this.ReturnDate = ReturnDate;
        this.member = member;
        this.book = book;
    }

    public Emprunt() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getEmpruntDate() {
        return EmpruntDate;
    }

    public void setEmpruntDate(ZonedDateTime EmpruntDate) {
        this.EmpruntDate = EmpruntDate;
    }

    public ZonedDateTime getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(ZonedDateTime ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    
}
