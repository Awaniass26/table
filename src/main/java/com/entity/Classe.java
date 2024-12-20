package com.entity;


import java.util.List;

public class Classe {
    private String nom;
    private Niveau niveau;
    private List<Etudiant> etudiants;

    public Classe(String nom, Niveau niveau) {
        this.nom = nom;
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public Niveau getNiveau() {
        return niveau;
    }
}
