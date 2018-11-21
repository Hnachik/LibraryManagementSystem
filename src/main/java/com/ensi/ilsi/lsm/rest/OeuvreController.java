/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.rest;

import com.ensi.ilsi.lsm.entities.Oeuvre;
import com.ensi.ilsi.lsm.services.OeuvreService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Amin
 */
@RestController
@RequestMapping("/oeuvre")
public class OeuvreController {
@Autowired
    private OeuvreService oeuvreService;

    @GetMapping
    public List<Oeuvre> findAll() {
        return this.oeuvreService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Oeuvre> findById(@PathVariable Long id) {
        return this.oeuvreService.findById(id);
    }

    @PostMapping
    public Oeuvre create(@RequestBody Oeuvre oeuvre) {
        return this.oeuvreService.create(oeuvre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.oeuvreService.delete(id);
    }
    
}
