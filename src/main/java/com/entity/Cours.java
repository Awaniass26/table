package com.entity;

import java.util.List;

public class Cours {
    private int id;  
    private String nom;
    private Professeur professeur;
    private List<Classe> classes;

    public Cours() {}

    public Cours(String nom, Professeur professeur, List<Classe> classes) {
        this.nom = nom;
        this.professeur = professeur;
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Cours{id=" + id + ", nom='" + nom + "', professeur=" + professeur.getNom() + " " + professeur.getPrenom() + "}";
    }
}
