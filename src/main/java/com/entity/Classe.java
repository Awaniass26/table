package com.entity;

import java.util.List;

public class Classe {
    private int id;  
    private String nom;
    private Niveau niveau;
    private List<Etudiant> etudiants;

    public Classe() {}

    public Classe(String nom, Niveau niveau) {
        this.nom = nom;
        this.niveau = niveau;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    @Override
    public String toString() {
        return "Classe{id=" + id + ", nom='" + nom + "', niveau=" + niveau.getNom() + "}";
    }
}
