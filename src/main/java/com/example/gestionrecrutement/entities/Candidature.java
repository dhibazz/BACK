package com.example.gestionrecrutement.entities;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Candidature {
    @EmbeddedId
    Candidature_key id;




    
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;



    @ManyToOne
    @MapsId("offreId")
    @JoinColumn(name = "offre_id")
    Offre offre;


    
	@Column(name = "date")
	 private String date;
     @Column(name = "etat")
    private String etat;

    @Column(name = "cv")
    private String cv;
}
