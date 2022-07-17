package com.example.gestionrecrutement.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable

public class Candidature_key implements Serializable {

    
    @Column
    private Long  userId;

    @Column
    private Long  offreId;
    
}
