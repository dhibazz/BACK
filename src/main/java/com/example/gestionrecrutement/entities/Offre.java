package com.example.gestionrecrutement.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "offre_entity")
public class Offre {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")	
	private long id;


	@OneToMany(mappedBy = "offre")
    Set<Candidature> candidatures;

	@Column(name = "poste")
	 private String poste;
	  
	 @Column(name = "description")
	 private String description;
	  
	 @Column(name = "emplacement")
	 private String emplacement;
	  
	 @Column(name = "experience")
	 private String experience;
	  
	 
	 @Column(name = "type")
	 private String type;
	  
	 @Column(name = "niveau")
	 private String niveau;
	 
	 
	 @Column(name = "typeemploi")
	 private String typeemploi;
	
	 
	 public Offre() {
			super();
			
		}
	public Offre(String poste, String description, String emplacement, String experience, String type, String niveau,
			String typeemploi) {
		super();
		this.poste = poste;
		this.description = description;
		this.emplacement = emplacement;
		this.experience = experience;
		this.type = type;
		this.niveau = niveau;
		this.typeemploi = typeemploi;}
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getTypeemploi() {
		return typeemploi;
	}
	public void setTypeemploi(String typeemploi) {
		this.typeemploi = typeemploi;
	}


	@Override
	public String toString() {
		return "Offre [id=" + id + ", poste=" + poste + ", description=" + description + ", emplacement=" + emplacement
				+ ", experience=" + experience + ", type=" + type + ", niveau=" + niveau + ", typeemploi=" + typeemploi
				+ "]";
	}


}
