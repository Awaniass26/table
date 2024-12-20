package com.services;

import com.entity.Professeur;
import java.util.List;

public interface ProfesseurService {
    void ajouterProfesseur(Professeur professeur);
    Professeur trouverProfesseurParNom(String nom);
    List<Professeur> listerProfesseurs();
}
