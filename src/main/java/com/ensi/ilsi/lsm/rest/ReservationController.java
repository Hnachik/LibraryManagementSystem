/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.rest;

import com.ensi.ilsi.lsm.entities.Reservation;
import com.ensi.ilsi.lsm.services.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Amin
 */
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> findAll() {
        return this.reservationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> findById(@PathVariable Long id) {
        return this.reservationService.findById(id);
    }

    @PostMapping
    public Reservation create(@RequestBody Reservation r) {
        return this.reservationService.create(r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.reservationService.delete(id);
    }
    
}
