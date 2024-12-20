package com.repository.bd;

import com.entity.Session;
import com.entity.Cours;
import com.core.bd.DatabaseImpl;
import com.repository.SessionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionRepositoryBd implements SessionRepository {

    private DatabaseImpl database;

    public SessionRepositoryBd() {
        this.database = new DatabaseImpl();
    }

    @Override
    public void save(Session session) {
        String sql = "INSERT INTO session (date, cours_id, heure_debut, heure_fin, salle) VALUES (?, ?, ?, ?, ?)";
        try {
            database.initPreparedStatement(sql);
            database.statement.setDate(1, new java.sql.Date(session.getDate().getTime()));  // Convert java.util.Date to java.sql.Date
            database.statement.setInt(2, session.getCours().getId());  // Set the cours_id
            database.statement.setTime(3, new java.sql.Time(session.getHeureDebut().getTime())); // Convert heureDebut
            database.statement.setTime(4, new java.sql.Time(session.getHeureFin().getTime()));   // Convert heureFin
            database.statement.setString(5, session.getSalle()); // Set salle
            int rowsAffected = database.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Session ajoutée avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.CloseConnection();
        }
    }

    @Override
    public List<Session> findByCours(Cours cours) {
        List<Session> result = new ArrayList<>();
        String sql = "SELECT * FROM session WHERE cours_id = ?";
        try {
            database.initPreparedStatement(sql);
            database.statement.setInt(1, cours.getId());  
            ResultSet rs = database.executeSelect();
            while (rs.next()) {
                Session session = new Session();
                session.setId(rs.getInt("id"));
                session.setDate(rs.getDate("date"));  
                session.setHeureDebut(rs.getTime("heure_debut"));
                session.setHeureFin(rs.getTime("heure_fin"));
                session.setSalle(rs.getString("salle"));
                session.setCours(cours);  

                result.add(session);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.CloseConnection();
        }
        return result;
    }
}
