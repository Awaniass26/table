package com.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode()

public class Session {
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String salle;

    public Session(LocalDate date, LocalTime heureDebut, LocalTime heureFin, String salle) {
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.salle = salle;
    }

}
