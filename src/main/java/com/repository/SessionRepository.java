package com.repository;

import java.util.ArrayList;
import java.util.List;

import com.entity.Cours;
import com.entity.Session;

public class SessionRepository {
    private List<Session> sessionList = new ArrayList<>();

    public void save(Session session) {
        sessionList.add(session);
    }

    public List<Session> findByCours(Cours cours) {
        List<Session> result = new ArrayList<>();
        for (Session session : sessionList) {
            if (session.getCours().equals(cours)) {
                result.add(session);
            }
        }
        return result;
    }
}
