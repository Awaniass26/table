package com.services;

import java.util.List;

import com.entity.Classe;
import com.entity.Cours;
import com.entity.Niveau;
import com.entity.Professeur;
import com.repository.CoursRepository;

public class CoursService {
    private CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public void creerCours(String nom, Professeur professeur, List<Classe> classes) {
        Cours cours = new Cours(nom, professeur, classes);
        coursRepository.save(cours);
    }

    public List<Cours> afficherCoursParNiveau(Niveau niveau) {
        return coursRepository.findByNiveau(niveau);
    }
}

