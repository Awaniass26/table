package com.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode()

public class Etudiant {
    private String nom;
    private String prenom;
    private Classe classe;

    public Etudiant(String nom, String prenom, Classe classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
    }

   
}