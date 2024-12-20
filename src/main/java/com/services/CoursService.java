package com.services;

import java.util.List;

import com.entity.Cours;
import com.entity.Niveau;
import com.entity.Classe;
import com.entity.Professeur;

public interface CoursService {
    void creerCours(String nom, Professeur professeur, List<Classe> classes);
    List<Cours> afficherCoursParNiveau(Niveau niveau);
}
