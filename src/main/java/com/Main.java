package com;

import com.repository.ClasseRepository;
import com.repository.CoursRepository;
import com.repository.SessionRepository;
import com.services.ClasseService;
import com.services.CoursService;
import com.services.SessionService;
import com.views.AdminView;

public class Main {
    public static void main(String[] args) {
        CoursRepository coursRepository = new CoursRepository();
        ClasseRepository classeRepository = new ClasseRepository();
        SessionRepository sessionRepository = new SessionRepository();

        CoursService coursService = new CoursService(coursRepository);
        ClasseService classeService = new ClasseService(classeRepository);
        SessionService sessionService = new SessionService(sessionRepository);

        AdminView adminView = new AdminView(coursService, classeService, sessionService);
        adminView.afficherMenuAdmin();
    }
}
