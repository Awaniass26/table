package com.views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("Menu Admin:");
            System.out.println("1. Créer un cours");
            System.out.println("2. Afficher les cours d'un niveau");
            System.out.println("3. Créer une classe");
            System.out.println("4. Planifier une session de cours");
            System.out.println("5. Afficher les sessions d'un cours");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option: ");
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
                case 6:
                    continueRunning = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }

    public void creerCours() {
        System.out.print("Nom du cours: ");
        String nom = scanner.next();
        System.out.print("Professeur: ");
        String professeurNom = scanner.next();
        Professeur professeur = new Professeur(professeurNom, "Prenom");

        System.out.print("Combien de classes ? ");
        int nbClasses = scanner.nextInt();
        List<Classe> classes = new ArrayList<>();
        for (int i = 0; i < nbClasses; i++) {
            System.out.print("Nom de la classe " + (i + 1) + ": ");
            String classeNom = scanner.next();
            classes.add(new Classe(classeNom, new Niveau("Niveau1"))); 
        }

        coursService.creerCours(nom, professeur, classes);
        System.out.println("Cours créé avec succès !");
    }

    public void afficherCoursParNiveau() {
        System.out.print("Nom du niveau: ");
        String niveauNom = scanner.next();
        Niveau niveau = new Niveau(niveauNom);
        List<Cours> coursList = coursService.afficherCoursParNiveau(niveau);

        if (coursList.isEmpty()) {
            System.out.println("Aucun cours trouvé pour ce niveau.");
        } else {
            for (Cours cours : coursList) {
                System.out.println("Cours: " + cours.getNom());
            }
        }
    }

    public void creerClasse() {
        System.out.print("Nom de la classe: ");
        String nom = scanner.next();
        Classe classe = new Classe(nom, new Niveau("Niveau1"));
        classeService.creerClasse(nom, new Niveau("Niveau1"));
        System.out.println("Classe créée avec succès !");
    }

    public void planifierSession() {
        System.out.print("Nom du cours: ");
        String nomCours = scanner.next();
        Cours cours = new Cours(nomCours, new Professeur("Professeur1", "Prenom"), new ArrayList<>());

         System.out.print("Date de la session (format: yyyy-MM-dd): ");
        String dateString = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString); 
        } catch (Exception e) {
            System.out.println("Erreur de format de date");
            return;
        }

        System.out.print("Heure début (format: HH:mm): ");
        String heureDebutString = scanner.next();
        SimpleDateFormat heureFormat = new SimpleDateFormat("HH:mm");
        Date heureDebut = null;
        try {
            heureDebut = heureFormat.parse(heureDebutString); 
        } catch (Exception e) {
            System.out.println("Erreur de format de l'heure de début");
            return;
        }

        System.out.print("Heure fin (format: HH:mm): ");
        String heureFinString = scanner.next();
        Date heureFin = null;
        try {
            heureFin = heureFormat.parse(heureFinString); 
        } catch (Exception e) {
            System.out.println("Erreur de format de l'heure de fin");
            return;
        }

        System.out.print("Salle: ");
        String salle = scanner.next();

        sessionService.planifierSession(cours, date, heureDebut, heureFin, salle);
        System.out.println("Session planifiée avec succès !");
    }

    public void afficherSessionsParCours() {
        System.out.print("Nom du cours: ");
        String nomCours = scanner.next();
        Cours cours = new Cours(nomCours, new Professeur("Professeur1", "Prenom"), new ArrayList<>());
        List<Session> sessions = sessionService.afficherSessionsParCours(cours);
        
        if (sessions.isEmpty()) {
            System.out.println("Aucune session trouvée pour ce cours.");
        } else {
            for (Session session : sessions) {
                System.out.println("Session de " + session.getCours().getNom());
                System.out.println("Date: " + session.getDate());
                System.out.println("Heure: " + session.getHeureDebut() + " - " + session.getHeureFin());
                System.out.println("Salle: " + session.getSalle());
            }
        }
    }
}
