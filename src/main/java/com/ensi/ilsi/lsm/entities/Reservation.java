/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.entities;

import java.time.ZonedDateTime;
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
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "booking_date")
    private ZonedDateTime bookingDate;
    
    @ManyToOne
    private Member member;
    
    @ManyToOne
    private Oeuvre oeuvre;

    public Reservation(long id, ZonedDateTime bookingDate, Member member, Oeuvre oeuvre) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.member = member;
        this.oeuvre = oeuvre;
    }

    public Reservation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ZonedDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(ZonedDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }
    
}
