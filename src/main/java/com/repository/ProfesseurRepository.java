package com.repository;

import com.entity.Professeur;
import java.util.List;

public interface ProfesseurRepository {
    void save(Professeur professeur);
    Professeur findByName(String name);
    List<Professeur> findAll();
}
