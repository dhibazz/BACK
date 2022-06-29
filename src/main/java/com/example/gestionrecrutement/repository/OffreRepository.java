package com.example.gestionrecrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionrecrutement.entities.Offre;


@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {
	 Offre findById(long id);

}
