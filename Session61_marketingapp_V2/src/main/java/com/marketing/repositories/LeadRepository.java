package com.marketing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketing.entities.Lead;

//extends JpaRepository and import(import org.springframework.data.jpa.repository.JpaRepository;)
//Lead is Entity Class and Long is Wrapper class.
public interface LeadRepository extends JpaRepository<Lead, Long> {

}
