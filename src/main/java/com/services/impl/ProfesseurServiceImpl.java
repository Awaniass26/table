package com.services.impl;

import com.entity.Professeur;
import com.repository.ProfesseurRepository;
import com.services.ProfesseurService;

import java.util.List;

public class ProfesseurServiceImpl implements ProfesseurService {
    private ProfesseurRepository professeurRepository;

    public ProfesseurServiceImpl(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    @Override
    public void ajouterProfesseur(Professeur professeur) {
        professeurRepository.save(professeur);
    }

    @Override
    public Professeur trouverProfesseurParNom(String nom) {
        return professeurRepository.findByName(nom);
    }

    @Override
    public List<Professeur> listerProfesseurs() {
        return professeurRepository.findAll();
    }
}
