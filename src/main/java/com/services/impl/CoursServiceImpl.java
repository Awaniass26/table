package com.services.impl;


import java.util.List;

import com.entity.Cours;
import com.entity.Classe;
import com.entity.Niveau;
import com.entity.Professeur;
import com.repository.CoursRepository;
import com.services.CoursService;

public class CoursServiceImpl implements CoursService {

    private CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public void creerCours(String nom, Professeur professeur, List<Classe> classes) {
        Cours cours = new Cours(nom, professeur, classes);
        coursRepository.save(cours); 
    }

    @Override
    public List<Cours> afficherCoursParNiveau(Niveau niveau) {
        return coursRepository.findByNiveau(niveau); 
    }
}
