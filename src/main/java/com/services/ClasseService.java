package com.services;

import java.util.List;

import com.entity.Classe;
import com.entity.Niveau;

public interface ClasseService {
    void creerClasse(String nom, Niveau niveau);
    List<Classe> afficherClasses();
}
