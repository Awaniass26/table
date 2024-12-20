package com.views;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.entity.Classe;
import com.entity.Cours;
import com.entity.Niveau;
import com.entity.Professeur;
import com.services.Impl.CoursService;



public class CoursView {
    private final CoursService coursService;
    private final Scanner scanner;

    public CoursView(CoursService coursService) {
        this.coursService = coursService;
        this.scanner = new Scanner(System.in);
    }

    public void ajouterCours() {
        System.out.println("\n===== Ajouter un cours =====");
        System.out.print("Nom du cours : ");
        String nom = scanner.nextLine();

        System.out.print("Nom du module : ");
        String module = scanner.nextLine();

        System.out.print("Nom du professeur : ");
        String nomProf = scanner.nextLine();
        Professeur professeur = new Professeur(nomProf);

        List<Classe> classes = new ArrayList<>();
        System.out.print("Nombre de classes pour ce cours : ");
        int nbClasses = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nbClasses; i++) {
            System.out.print("Nom de la classe " + (i + 1) + " : ");
            String nomClasse = scanner.nextLine();
            System.out.print("Niveau de la classe : ");
            String niveauClasse = scanner.nextLine();
            classes.add(new Classe(nomClasse, niveauClasse));
        }

        Cours cours = new Cours();
        coursService.ajouterCours(cours);
        System.out.println("Cours ajouté avec succès !");
    }

    public void ajouterNiveau() {
        System.out.println("\n===== Ajouter un niveau =====");
        System.out.print("Nom du niveau : ");
        String nomNiveau = scanner.nextLine();
        Niveau niveau = new Niveau(nomNiveau);
        System.out.println("Niveau '" + niveau.getNom() + "' ajouté avec succès !");
    }

    public void afficherTousLesCours() {
        System.out.println("\n===== Tous les cours =====");
        List<Cours> cours = coursService.afficherTousLesCours();
        if (cours.isEmpty()) {
            System.out.println("Aucun cours disponible.");
        } else {
            cours.forEach(System.out::println);
        }
    }

    public void afficherCoursParNiveau() {
        System.out.println("\n===== Cours par niveau =====");
        System.out.print("Nom du niveau : ");
        String niveau = scanner.nextLine();
        List<Cours> cours = coursService.afficherCoursParNiveau(niveau);
        if (cours.isEmpty()) {
            System.out.println("Aucun cours trouvé pour le niveau : " + niveau);
        } else {
            cours.forEach(System.out::println);
        }
    }

    public void afficherCoursParClasse() {
        System.out.println("\n===== Cours par classe =====");
        System.out.print("Nom de la classe : ");
        String classe = scanner.nextLine();
        List<Cours> cours = coursService.afficherCoursParClasse(classe);
        if (cours.isEmpty()) {
            System.out.println("Aucun cours trouvé pour la classe : " + classe);
        } else {
            cours.forEach(System.out::println);
        }
    }

    public void afficherCoursParProfesseur() {
        System.out.println("\n===== Cours par professeur =====");
        System.out.print("Nom du professeur : ");
        String professeur = scanner.nextLine();
        List<Cours> cours = coursService.afficherCoursParProfesseur(professeur);
        if (cours.isEmpty()) {
            System.out.println("Aucun cours trouvé pour le professeur : " + professeur);
        } else {
            cours.forEach(System.out::println);
        }
    }
}
