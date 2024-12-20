package com.repository.bd;

import com.entity.Professeur;
import com.repository.ProfesseurRepository;
import com.core.bd.DatabaseImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesseurRepositoryBd implements ProfesseurRepository {

    private DatabaseImpl database;

    public ProfesseurRepositoryBd(DatabaseImpl database) {
        this.database = database;
    }

    @Override
    public Professeur findById(int id) {
        String sql = "SELECT * FROM professeur WHERE id = ?";
        Professeur professeur = null;
        try {
            database.initPreparedStatement(sql);
            database.statement.setInt(1, id);
            ResultSet resultSet = database.executeQuery();
            if (resultSet.next()) {
                professeur = new Professeur(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeur;
    }

    @Override
    public void save(Professeur professeur) {
        String sql = "INSERT INTO professeur (nom, prenom) VALUES (?, ?)";
        try {
            database.initPreparedStatement(sql);
            database.statement.setString(1, professeur.getNom());
            database.statement.setString(2, professeur.getPrenom());
            int rowsAffected = database.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Professeur ajouté avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Professeur> findAll() {
        String sql = "SELECT * FROM professeur";
        List<Professeur> professeurs = new ArrayList<>();
        try {
            database.initPreparedStatement(sql);
            ResultSet resultSet = database.executeQuery();
            while (resultSet.next()) {
                Professeur professeur = new Professeur(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom")
                );
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM professeur WHERE id = ?";
        try {
            database.initPreparedStatement(sql);
            database.statement.setInt(1, id);
            int rowsAffected = database.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Professeur supprimé avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
