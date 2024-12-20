package com.entity;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Cours {
    private String nom;
    private Professeur professeur;
    private List<Classe> classes;
    private String module;

    public Cours(String nom, Professeur professeur, List<Classe> classes, String module) {
        this.nom = nom;
        this.professeur = professeur;
        this.classes = classes;
        this.module = module;
    }

    // Getter explicite pour classes
    public List<Classe> getClasses() {
        if (classes == null) {
            throw new IllegalStateException("La liste des classes n'a pas été initialisée.");
        }
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    // Autres getters et setters si nécessaires
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

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
