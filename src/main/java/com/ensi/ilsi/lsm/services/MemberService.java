/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.services;

/**
 *
 * @author Amin
 */
import com.ensi.ilsi.lsm.entities.Member;
import com.ensi.ilsi.lsm.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class MemberService {
    private final Logger log = LoggerFactory.getLogger(MemberService.class);

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member create(Member member) {
        log.debug("Request to create member : {}", member);
        
        return  this.memberRepository.save(member
                       
                );
    }

    public List<Member> findAll() {
        log.debug("Request to get all Members");
        return this.memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Member> findById(Long id) {
        log.debug("Request to get Member : {}", id);
        return this.memberRepository.findById(id);
    }
    
    public void delete(Long id) {
        log.debug("Request to delete Member : {}", id);

        Member member = this.memberRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find member with id " + id));

        this.memberRepository.delete(member);
    }

}
