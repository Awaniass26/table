package com.views;


import java.util.Scanner;

import com.services.Impl.CoursService;

public class AdminView {
    private final CoursService coursService;
    private final Scanner scanner;
    private final CoursView coursView;

    public AdminView(CoursService coursService) {
        this.coursService = coursService;
        this.scanner = new Scanner(System.in);
        this.coursView = new CoursView(coursService);
    }

    public void afficherMenu() {
        while (true) {
            System.out.println("\n===== Menu Admin =====");
            System.out.println("1. Ajouter un cours");
            System.out.println("2. Afficher tous les cours");
            System.out.println("3. Afficher les cours par niveau");
            System.out.println("4. Afficher les cours par classe");
            System.out.println("5. Afficher les cours par professeur");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    coursView.ajouterCours();
                    break;
                case 2:
                    coursView.afficherTousLesCours();
                    break;
                case 3:
                    coursView.afficherCoursParNiveau();
                    break;
                case 4:
                    coursView.afficherCoursParClasse();
                    break;
                case 5:
                    coursView.afficherCoursParProfesseur();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}
