package com.views;

import java.util.ArrayList;
// AdminView.java
import java.util.List;
import java.util.Scanner;

import com.entity.Classe;
import com.entity.Cours;
import com.entity.Niveau;
import com.entity.Professeur;
import com.entity.Session;
import com.services.ClasseService;
import com.services.CoursService;
import com.services.SessionService;

public class AdminView {
    private CoursService coursService;
    private ClasseService classeService;
    private SessionService sessionService;
    private Scanner scanner;

    public AdminView(CoursService coursService, ClasseService classeService, SessionService sessionService) {
        this.coursService = coursService;
        this.classeService = classeService;
        this.sessionService = sessionService;
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenuAdmin() {
        System.out.println("Menu Admin:");
        System.out.println("1. Créer un cours");
        System.out.println("2. Afficher les cours d'un niveau");
        System.out.println("3. Créer une classe");
        System.out.println("4. Planifier une session de cours");
        System.out.println("5. Afficher les sessions d'un cours");
        System.out.println("Choisissez une option:");
        int choix = scanner.nextInt();
        switch (choix) {
            case 1:
                creerCours();
                break;
            case 2:
                afficherCoursParNiveau();
                break;
            case 3:
                creerClasse();
                break;
            case 4:
                planifierSession();
                break;
            case 5:
                afficherSessionsParCours();
                break;
            default:
                System.out.println("Option invalide");
        }
    }

    public void creerCours() {
        System.out.println("Nom du cours:");
        String nom = scanner.next();
        // Demander professeur et classes associés
        // Exemple : ajouter un professeur et une liste de classes
        System.out.println("Professeur:");
        String professeurNom = scanner.next();
        Professeur professeur = new Professeur(professeurNom, "Prenom");
        System.out.println("Combien de classes ?");
        int nbClasses = scanner.nextInt();
        List<Classe> classes = new ArrayList<>();
        for (int i = 0; i < nbClasses; i++) {
            System.out.println("Nom de la classe " + (i+1) + ":");
            String classeNom = scanner.next();
            classes.add(new Classe(classeNom, new Niveau("Niveau1")));
        }
        coursService.creerCours(nom, professeur, classes);
    }

    public void afficherCoursParNiveau() {
        System.out.println("Nom du niveau:");
        String niveauNom = scanner.next();
        Niveau niveau = new Niveau(niveauNom);
        List<Cours> coursList = coursService.afficherCoursParNiveau(niveau);
        for (Cours cours : coursList) {
            System.out.println("Cours: " + cours.getNom());
        }
    }

    public void creerClasse() {
        System.out.println("Nom de la classe:");
        String nom = scanner.next();
        // Créer la classe avec un niveau par défaut
        Classe classe = new Classe(nom, new Niveau("Niveau1"));
        classeService.creerClasse(nom, new Niveau("Niveau1"));
    }

    public void planifierSession() {
        System.out.println("Nom du cours:");
        String nomCours = scanner.next();
        Cours cours = new Cours(nomCours, new Professeur("Professeur1", "Prenom"), new ArrayList<>());
        // Ajouter détails de la session et planifier
    }

    public void afficherSessionsParCours() {
        System.out.println("Nom du cours:");
        String nomCours = scanner.next();
        Cours cours = new Cours(nomCours, new Professeur("Professeur1", "Prenom"), new ArrayList<>());
        List<Session> sessions = sessionService.afficherSessionsParCours(cours);
        for (Session session : sessions) {
            System.out.println("Session de " + session.getCours().getNom());
        }
    }
}
