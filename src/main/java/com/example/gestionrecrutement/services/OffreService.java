package com.example.gestionrecrutement.services;

import com.example.gestionrecrutement.entities.Offre;
import com.example.gestionrecrutement.repository.OffreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
 public class OffreService {
    @Autowired
    private OffreRepository offreRepository;

    public void addOffre(Offre offre) {
        offreRepository.save(offre);
    }

    public List<Offre> getAllOffres() {
        return   offreRepository.findAll();
    }
    
    
    public void deleteOffre(long id) {
       Offre offre = offreRepository.findById(id);
       if(offre != null) {
        offreRepository.delete(offre);}
    }
    
    
    public void updateOffre(long idOffre, Offre offre) {
        Offre oldoffre=offreRepository.findById(idOffre);
        oldoffre.setPoste(offre.getPoste());
        oldoffre.setDescription(offre.getDescription());
        oldoffre.setEmplacement(offre.getEmplacement());
        oldoffre.setExperience(offre.getExperience());
        oldoffre.setType(offre.getType());
        oldoffre.setNiveau(offre.getNiveau());
        oldoffre.setTypeemploi(offre.getTypeemploi());
        offreRepository.save(oldoffre);

    }

    public Offre getOffreByid(long id) {
        return offreRepository.findById(id);
    }
}