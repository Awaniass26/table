package com.services.Impl;

import java.util.List;

import com.entity.Cours;

public interface CoursService {
    void ajouterCours(Cours cours);
    List<Cours> afficherTousLesCours();
    List<Cours> afficherCoursParNiveau(String niveau);
    List<Cours> afficherCoursParClasse(String classe);
    List<Cours> afficherCoursParProfesseur(String professeur);
    void supprimerCours(Cours cours); 
    List<Cours> afficherCours();  
}