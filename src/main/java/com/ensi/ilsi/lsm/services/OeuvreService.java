/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.services;

import com.ensi.ilsi.lsm.entities.Oeuvre;
import com.ensi.ilsi.lsm.repository.OeuvreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Amin
 */
@Service
@Transactional
public class OeuvreService {
    private final Logger log = LoggerFactory.getLogger(OeuvreService.class);

    private final OeuvreRepository oeuvreRepository;

    public OeuvreService(OeuvreRepository oeuvreRepository) {
        this.oeuvreRepository = oeuvreRepository;
    }

    public Oeuvre create(Oeuvre oeuvre) {
        log.debug("Request to create oeuvre : {}", oeuvre);
        return  this.oeuvreRepository.save(
                        new Oeuvre(
                                oeuvre.getId(),
                                oeuvre.getBookName(),
                                oeuvre.getISBN(),
                                oeuvre.getPublisher(),
                                oeuvre.getFreeBooks(),
                                oeuvre.getBooks(),
                                oeuvre.getReservations()
                            )
                );
    }

    public List<Oeuvre> findAll() {
        log.debug("Request to get all oeuvres");
        return this.oeuvreRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Oeuvre> findById(Long id) {
        log.debug("Request to get oeuvre : {}", id);
        return this.oeuvreRepository.findById(id);
    }
    
    public void delete(Long id) {
        log.debug("Request to delete oeuvre: {}", id);

        Oeuvre oeuvre = this.oeuvreRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find oeuvre with id " + id));

        this.oeuvreRepository.delete(oeuvre);
    }  
    
}
