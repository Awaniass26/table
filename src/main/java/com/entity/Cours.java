package com.entity;

import java.util.List;

public class Cours {
    private String nom;
    private Professeur professeur;
    private List<Classe> classes;

    public Cours(String nom, Professeur professeur, List<Classe> classes) {
        this.nom = nom;
        this.professeur = professeur;
        this.classes = classes;
    }

    public String getNom() {
        return nom;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public List<Classe> getClasses() {
        return classes;
    }
}
