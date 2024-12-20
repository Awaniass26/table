package com.repository;

import java.util.List;
import com.entity.Classe;

public interface ClasseRepository {
    void save(Classe classe);
    List<Classe> findAll();
}
