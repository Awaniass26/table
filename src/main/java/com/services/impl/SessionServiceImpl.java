package com.services.impl;


import java.util.Date;
import java.util.List;

import com.entity.Cours;
import com.entity.Session;
import com.repository.SessionRepository;
import com.services.SessionService;

public class SessionServiceImpl implements SessionService {

    private SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void planifierSession(Cours cours, Date date, Date heureDebut, Date heureFin, String salle) {
        Session session = new Session(cours, date, heureDebut, heureFin, salle);
        sessionRepository.save(session); 
    }

    @Override
    public List<Session> afficherSessionsParCours(Cours cours) {
        return sessionRepository.findByCours(cours); 
    }
}
