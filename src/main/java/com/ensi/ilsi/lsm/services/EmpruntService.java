/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.services;

import com.ensi.ilsi.lsm.entities.Emprunt;
import com.ensi.ilsi.lsm.repository.EmpruntRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amin
 */
@Service
@Transactional
public class EmpruntService {
    private final Logger log = LoggerFactory.getLogger(EmpruntService.class);

    private final EmpruntRepository empruntRepository;

    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    public Emprunt create(Emprunt emprunt) {
        log.debug("Request to create emprunt : {}", emprunt);
        return  this.empruntRepository.save(
                        new Emprunt(
                                emprunt.getId(),
                                emprunt.getEmpruntDate(),
                                emprunt.getReturnDate(),
                                emprunt.getMember(),
                                emprunt.getBook()
                            )
                );
    }

    public List<Emprunt> findAll() {
        log.debug("Request to get all emprunts");
        return this.empruntRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Emprunt> findById(Long id) {
        log.debug("Request to get emprunt : {}", id);
        return this.empruntRepository.findById(id);
    }
    
    public void delete(Long id) {
        log.debug("Request to delete emprunt: {}", id);

        Emprunt emprunt = this.empruntRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find emprunt with id " + id));

        this.empruntRepository.delete(emprunt);
    }
    
}
