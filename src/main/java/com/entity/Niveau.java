package com.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode()

public class Niveau {
    private String nom;

    public Niveau(String nom) {
        this.nom = nom;
    }

}
