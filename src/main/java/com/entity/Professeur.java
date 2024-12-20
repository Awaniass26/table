package com.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode()

public class Professeur {
    private String nom;
    private String specialite;

    public Professeur(String nom, String specialite) {
        this.nom = nom;
        this.specialite = specialite;
    }

    public Professeur(String nom) {
        this.nom = nom;
        
    }

   
}

