package com.repository;

import com.entity.Cours;
import com.entity.Session;
import java.util.List;

public interface SessionRepository {

    void save(Session session);  
    List<Session> findByCours(Cours cours);  
}
