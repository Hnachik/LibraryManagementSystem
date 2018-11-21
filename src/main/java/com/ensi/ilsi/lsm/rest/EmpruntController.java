/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.rest;

import com.ensi.ilsi.lsm.entities.Emprunt;
import com.ensi.ilsi.lsm.services.EmpruntService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Amin
 */
@RestController
@RequestMapping("/emprunts")
public class EmpruntController {
    
    @Autowired
    private EmpruntService empruntService;

    @GetMapping
    public List<Emprunt> findAll() {
        return this.empruntService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Emprunt> findById(@PathVariable Long id) {
        return this.empruntService.findById(id);
    }

    @PostMapping
    public Emprunt create(@RequestBody Emprunt e) {
        return this.empruntService.create(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.empruntService.delete(id);
    }
}
