package com.services.impl;

import java.util.List;

import com.entity.Classe;
import com.entity.Niveau;
import com.repository.ClasseRepository;
import com.services.ClasseService;

public class ClasseServiceImpl implements ClasseService {

    private ClasseRepository classeRepository;

    public ClasseServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public void creerClasse(String nom, Niveau niveau) {
        Classe classe = new Classe(nom, niveau);
        classeRepository.save(classe); 
    }

    @Override
    public List<Classe> afficherClasses() {
        return classeRepository.findAll(); 
    }
}
