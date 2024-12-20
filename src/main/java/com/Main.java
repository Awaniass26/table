package com;

import com.repository.list.CoursRepositoryList;
import com.services.Impl.CoursServiceImpl;
import com.views.AdminView;

public class Main {
    public static void main(String[] args) {
        CoursRepositoryList coursRepository = new CoursRepositoryList();
        CoursServiceImpl coursService = new CoursServiceImpl(coursRepository);
        AdminView adminView = new AdminView(coursService);
        adminView.afficherMenu();
    }
}