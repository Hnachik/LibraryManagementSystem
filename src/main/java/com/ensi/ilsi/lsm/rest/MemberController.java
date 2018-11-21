/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.lsm.rest;

import com.ensi.ilsi.lsm.entities.Member;
import com.ensi.ilsi.lsm.services.MemberService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Amin
 */
@RestController
@RequestMapping("/members")
public class MemberController {
        @Autowired
        private MemberService memberService;

        @GetMapping
        public List<Member> findAll() {
            return this.memberService.findAll();
        }
        
        @GetMapping("/{id}")
        public Optional<Member> findById(@PathVariable Long id) {
            return this.memberService.findById(id);
        }
        
	@PostMapping
	public Member create(@RequestBody Member m) {
            System.out.println(m.getFirstname());
	   return this.memberService.create(m);
        }
        
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            this.memberService.delete(id);
        }
}

