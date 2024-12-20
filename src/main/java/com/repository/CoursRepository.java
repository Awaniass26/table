package com.repository;

import com.entity.Classe;
import com.entity.Cours;
import com.entity.Niveau;

import java.util.List;
import java.util.ArrayList;

public class CoursRepository {
    private List<Cours> coursList = new ArrayList<>();

    public void save(Cours cours) {
        coursList.add(cours);
    }

    public List<Cours> findByNiveau(Niveau niveau) {
        List<Cours> result = new ArrayList<>();
        for (Cours cours : coursList) {
            for (Classe classe : cours.getClasses()) {
                if (classe.getNiveau().equals(niveau)) {
                    result.add(cours);
                }
            }
        }
        return result;
    }
}
