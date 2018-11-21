/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.entities;

import com.ensi.ilsi.lsm.entities.enumeration.BookStatus;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Amin
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "compteur")
    private int compteur;
    
    @Column(name = "inventory_number")
    private int IventoryNumber;
    
    @Column(name = "book_status")
    @Enumerated(EnumType.STRING)
    private BookStatus status;
    
    @OneToMany(mappedBy = "book")
    private List<Emprunt> emprunts;
    
    @ManyToOne
    private Oeuvre oeuvre;

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public Book(Long id, int compteur, int IventoryNumber, BookStatus status, List<Emprunt> emprunts, Oeuvre oeuvre) {
        this.id = id;
        this.compteur = compteur;
        this.IventoryNumber = IventoryNumber;
        this.status = status;
        this.emprunts = emprunts;
        this.oeuvre = oeuvre;
    }

    

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public int getIventoryNumber() {
        return IventoryNumber;
    }

    public void setIventoryNumber(int IventoryNumber) {
        this.IventoryNumber = IventoryNumber;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    
}
