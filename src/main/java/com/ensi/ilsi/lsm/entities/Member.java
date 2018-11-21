/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;



/**
 *
 * @author Amin
 */
@Entity
@Table(name = "member")
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "first_name")
    private String firstname;
    
    @Column(name = "last_name")
    private String lastname;
    
    @Email
    @Column(name = "email")
    private String email;
    
    @Column(name="city")
    private String city;
    
    @Column(name="post_code")
    private int postCode;
    
    @Column(name="phone_number")
    private int phoneNumber;
    
    @OneToMany(mappedBy = "member", targetEntity = Emprunt.class, cascade = CascadeType.PERSIST)
    @JsonManagedReference(value = "emp")
    private List<Emprunt> loans;
    
    @OneToMany(mappedBy = "member", targetEntity = Reservation.class)
    private List<Reservation> reservations;

    public Member(Long id, String firstname, String lastname, String email, String city, int postCode, int phoneNumber, List<Emprunt> loans, List<Reservation> reservations) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.city = city;
        this.postCode = postCode;
        this.phoneNumber = phoneNumber;
        this.loans = loans;
        this.reservations = reservations;
    }

    public Member() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) { 
        this.postCode = postCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Emprunt> getLoans() {
        return loans;
    }

    public void setLoans(List<Emprunt> loans) {
        this.loans = loans;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    
    
    
}
