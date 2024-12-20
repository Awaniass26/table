package com.services.Impl;


import java.util.List;

import com.entity.Cours;
import com.repository.CoursRepository;

public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public void ajouterCours(Cours cours) {
        coursRepository.inserer(cours);
    }

    @Override
    public List<Cours> afficherTousLesCours() {
        return coursRepository.selectionnerTout();
    }

    @Override
    public List<Cours> afficherCoursParNiveau(String niveau) {
        return coursRepository.rechercherParNiveau(niveau);
    }

    @Override
    public List<Cours> afficherCoursParClasse(String classe) {
        return coursRepository.rechercherParClasse(classe);
    }

    @Override
    public List<Cours> afficherCoursParProfesseur(String professeur) {
        return coursRepository.rechercherParProfesseur(professeur);
    }

    @Override
    public void supprimerCours(Cours cours) {
        coursRepository.supprimer(cours);
    }

    @Override
    public List<Cours> afficherCours() {
        return coursRepository.selectionnerTout();
    }

}
