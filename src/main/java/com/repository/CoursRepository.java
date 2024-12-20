package com.repository;

import com.entity.Cours;
import com.entity.Niveau;
import java.util.List;

public interface CoursRepository {
    void save(Cours cours);
    List<Cours> findByNiveau(Niveau niveau);
}
