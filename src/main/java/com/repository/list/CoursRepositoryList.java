package com.repository.list;

import java.util.List;
import java.util.stream.Collectors;

import com.entity.Cours;
import com.repository.CoursRepository;

public class CoursRepositoryList extends RepositoryListImpl<Cours> implements CoursRepository {

    @Override
    public List<Cours> rechercherParNiveau(String niveau) {
        return list.stream()
                .filter(cours -> cours.getClasses().stream()
                        .anyMatch(classe -> classe.getNiveau().equals(niveau)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cours> rechercherParClasse(String classe) {
        return list.stream()
                .filter(cours -> cours.getClasses().stream()
                        .anyMatch(c -> c.getNom().equals(classe)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cours> rechercherParProfesseur(String professeur) {
        return list.stream()
                .filter(cours -> cours.getProfesseur().getNom().equals(professeur))
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Cours cours) {
        list.remove(cours);
    }
}
