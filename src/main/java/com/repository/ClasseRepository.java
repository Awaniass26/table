package com.repository;

// ClasseRepository.java
import java.util.ArrayList;
import java.util.List;

import com.entity.Classe;

public class ClasseRepository {
    private List<Classe> classeList = new ArrayList<>();

    public void save(Classe classe) {
        classeList.add(classe);
    }

    public List<Classe> findAll() {
        return classeList;
    }
}

