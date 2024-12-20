package com.entity;

import java.util.Date;

public class Session {
    private Cours cours;
    private Date date;
    private Date heureDebut;
    private Date heureFin;
    private String salle;

    public Session(Cours cours, Date date, Date heureDebut, Date heureFin, String salle) {
        this.cours = cours;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.salle = salle;
    }

    public Cours getCours() {
        return cours;
    }

    public Date getDate() {
        return date;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public String getSalle() {
        return salle;
    }
}
