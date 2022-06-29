package com.example.gestionrecrutement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.gestionrecrutement.services.OffreService;
import com.example.gestionrecrutement.entities.Offre;

import org.springframework.http.MediaType;




@RestController //il s'agit d'une api rest
@RequestMapping("/api/Offre") // pathe global o ki n3aytou fi postman n7otou pathe global+getmapping
@CrossOrigin(origins = "http://localhost:8080") //pour indiquer domaine eli 7achti yekhdmou fih les requets piur acceder lel ressoureces taa les servers
public class OffreController {
   
	private static final String FoundOffre = null;
	@Autowired
	OffreService offreService;
	
   @SuppressWarnings("rawtypes")
   @Transactional
   @RequestMapping(value="/addOffre" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity addOffre(@RequestBody Offre offre){
	   offreService.addOffre(offre);
     return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @GetMapping("/getAllOffres")
   @RequestMapping(value="/getAllOffres" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<Offre>> getAllOffres(){
    List<Offre> offres=offreService.getAllOffres();
     return new ResponseEntity<List<Offre>>(offres, HttpStatus.OK);
    }
   
   @Transactional
   @DeleteMapping("/deleteOffre/{id}")
   public ResponseEntity<Object> deleteOffre(@PathVariable Long id){
       offreService.deleteOffre(id);
       return new ResponseEntity<>(HttpStatus.OK);
   }
   
   @SuppressWarnings("rawtypes")
   @Transactional
   @RequestMapping(value="/updateOffre/{id}" , method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity updateOffre(@PathVariable Long id,@RequestBody Offre offre){
        offreService.updateOffre(id,offre);
        return new ResponseEntity<>(HttpStatus.OK);
   }
        
   @Transactional
   @RequestMapping(value="/getOffre/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity getOffreById(@PathVariable Long id){
	    Offre FoundOffre = offreService.getOffreByid(id);
	    if (FoundOffre !=null)
	    return new ResponseEntity<>(FoundOffre,HttpStatus.OK);
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   
  
   
}