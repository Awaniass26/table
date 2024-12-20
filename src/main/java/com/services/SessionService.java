package com.services;

import java.util.Date;
import java.util.List;

import com.entity.Cours;
import com.entity.Session;
import com.repository.SessionRepository;

public class SessionService {
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void planifierSession(Cours cours, Date date, Date heureDebut, Date heureFin, String salle) {
        Session session = new Session(cours, date, heureDebut, heureFin, salle);
        sessionRepository.save(session);
    }

    public List<Session> afficherSessionsParCours(Cours cours) {
        return sessionRepository.findByCours(cours);
    }
}

