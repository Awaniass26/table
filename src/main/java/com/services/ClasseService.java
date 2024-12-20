package com.services;

import java.util.List;

import com.entity.Classe;
import com.entity.Niveau;
import com.repository.ClasseRepository;

public class ClasseService {
    private ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    public void creerClasse(String nom, Niveau niveau) {
        Classe classe = new Classe(nom, niveau);
        classeRepository.save(classe);
    }

    public List<Classe> afficherClasses() {
        return classeRepository.findAll();
    }
}
