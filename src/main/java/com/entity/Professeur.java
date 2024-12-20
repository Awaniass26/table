package com.entity;

public class Professeur {
    private String nom;
    private String prenom;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
