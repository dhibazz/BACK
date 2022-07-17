package com.example.gestionrecrutement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionrecrutement.entities.Candidature;
import com.example.gestionrecrutement.repository.CandidatureRepository;

@Service
public class CandidatureService {


    @Autowired
    private CandidatureRepository candidatureRepository;
    
    public void addCandidature(Candidature candidature) {
        candidatureRepository.save(candidature);
    }

    
      public  List<Candidature> getAllCandidatures() {
        return candidatureRepository.findAll();
    }
     

   




    
    public void deletecandidature(long id ) {
        Candidature candidature = candidatureRepository.findById(id);
        if(candidature != null) {
            candidatureRepository.delete(candidature);}
     }



     public void updatecandidature(Candidature candidature) {
       Candidature oldcandidature=candidatureRepository.findById(candidature.getId()).orElse(null);
        oldcandidature.setEtat(candidature.getEtat());
        candidatureRepository.save(oldcandidature);

    }





}
