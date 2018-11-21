/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.services;

import com.ensi.ilsi.lsm.entities.Reservation;
import com.ensi.ilsi.lsm.repository.ReservationRepository;
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
public class ReservationService {
    private final Logger log = LoggerFactory.getLogger(ReservationService.class);

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation create(Reservation reservation) {
        log.debug("Request to create emprunt : {}", reservation);
        return  this.reservationRepository.save(
                        new Reservation(
                                reservation.getId(),
                                reservation.getBookingDate(),
                                reservation.getMember(),
                                reservation.getOeuvre()
                            )
                );
    }

    public List<Reservation> findAll() {
        log.debug("Request to get all reservations");
        return this.reservationRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Reservation> findById(Long id) {
        log.debug("Request to get reservation : {}", id);
        return this.reservationRepository.findById(id);
    }
    
    public void delete(Long id) {
        log.debug("Request to delete reservation : {}", id);

        Reservation emprunt = this.reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find reservation with id " + id));

        this.reservationRepository.delete(emprunt);
    }
}
