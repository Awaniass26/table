package com.entity;


import java.util.List;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode()

public class Classe {
    private String nom;
    private String niveau;
    private List<Etudiant> etudiants;

    public Classe(String nom, String niveau, List<Etudiant> etudiants) {
        this.nom = nom;
        this.niveau = niveau;
        this.etudiants = etudiants;
    }


    public Classe(String nom, String niveau) {
        this.nom = nom;
        this.niveau = niveau;
    }


}