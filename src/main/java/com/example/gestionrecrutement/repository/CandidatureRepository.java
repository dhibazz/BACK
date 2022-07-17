package com.example.gestionrecrutement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gestionrecrutement.entities.Candidature;
import com.example.gestionrecrutement.entities.Candidature_key;


    @Repository

public interface CandidatureRepository extends JpaRepository<Candidature, Candidature_key > {

    
    Candidature findById(Long id);

}

