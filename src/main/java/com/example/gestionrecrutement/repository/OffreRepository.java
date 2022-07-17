package com.example.gestionrecrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gestionrecrutement.entities.Offre;




@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {
	// @Query(value:"select COUNT(CandidatureID), poste from candidature group By poste ")
	Offre findById(long id);

}
