package com.example.gestionrecrutement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionrecrutement.entities.Candidature;
import com.example.gestionrecrutement.services.CandidatureService;

@RestController 
@RequestMapping("/api/Candidature")
@CrossOrigin(origins = "*") 
public class CandidatureController {
    @Autowired
	CandidatureService candidatureService;

    @GetMapping("/getAllCandidatures")
   @RequestMapping(value="/getAllCandidatures" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<Candidature>> getAllCandidatures(){
    List<Candidature> candidatures=candidatureService.getAllCandidatures();
     return new ResponseEntity<List<Candidature>>(candidatures, HttpStatus.OK);
    }
    



    @SuppressWarnings("rawtypes")
    @Transactional
    @RequestMapping(value="/updatecandidature/{id}" , method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
     public  ResponseEntity updatecandidature(@RequestBody Candidature candidature){
         candidatureService.updatecandidature(candidature);
         return new ResponseEntity<>(HttpStatus.OK);
    }



    @Transactional
    @DeleteMapping("/deleteCandidature/{id}")
    public ResponseEntity<Object> deleteCandidature(@PathVariable Long id){
        candidatureService.deletecandidature(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
    @Transactional
    @RequestMapping(value="/addCandidature" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCandidature(@RequestBody Candidature candidature){
        candidatureService.addCandidature(candidature);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

