package com.services;

import java.util.Date;
import java.util.List;

import com.entity.Cours;
import com.entity.Session;

public interface SessionService {
    void planifierSession(Cours cours, Date date, Date heureDebut, Date heureFin, String salle);
    List<Session> afficherSessionsParCours(Cours cours);
}
