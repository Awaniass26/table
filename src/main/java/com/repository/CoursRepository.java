package com.repository;

import com.entity.Cours;

import java.util.List;

public interface CoursRepository {
    void inserer(Cours cours);
    List<Cours> selectionnerTout();
    List<Cours> rechercherParNiveau(String niveau);
    List<Cours> rechercherParClasse(String classe);
    List<Cours> rechercherParProfesseur(String professeur);
    void supprimer(Cours cours);
}