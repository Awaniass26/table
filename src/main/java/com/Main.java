package com;

import com.repository.bd.CoursRepositoryBd;
import com.repository.ProfesseurRepository;
import com.repository.bd.ClasseRepositoryBd;
import com.repository.bd.SessionRepositoryBd;
import com.services.impl.CoursServiceImpl;
import com.services.impl.ProfesseurServiceImpl;
import com.services.ProfesseurService;
import com.services.impl.ClasseServiceImpl;
import com.services.impl.SessionServiceImpl;
import com.views.AdminView;

public class Main {
    public static void main(String[] args) {
        CoursRepositoryBd coursRepository = new CoursRepositoryBd();
        ClasseRepositoryBd classeRepository = new ClasseRepositoryBd();
        SessionRepositoryBd sessionRepository = new SessionRepositoryBd();
        ProfesseurRepositoryBd professeurRepository = new ProfesseurRepositoryBd();

        ProfesseurServiceImpl professeurService = new ProfesseurServiceImpl(professeurRepository);
        CoursServiceImpl coursService = new CoursServiceImpl(coursRepository);
        ClasseServiceImpl classeService = new ClasseServiceImpl(classeRepository);
        SessionServiceImpl sessionService = new SessionServiceImpl(sessionRepository);

        AdminView adminView = new AdminView(coursService, classeService, sessionService, professeurService);
        
        adminView.afficherMenuAdmin();
    }
}
