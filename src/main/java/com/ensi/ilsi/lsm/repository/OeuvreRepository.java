/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.repository;

import com.ensi.ilsi.lsm.entities.Oeuvre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Amin
 */
@Repository
public interface OeuvreRepository extends JpaRepository<Oeuvre, Long> {
    
}
