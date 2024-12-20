package com.repository;

import com.entity.Professeur;

import java.util.List;

public interface ProfesseurRepository{
    Professeur findById(int id);
    
    void save(Professeur professeur);
    
    List<Professeur> findAll();
    
    void delete(int id);
}
