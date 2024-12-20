package com.repository.bd;


import com.entity.Professeur;
import com.repository.ProfesseurRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesseurRepositoryBd implements ProfesseurRepository {
    private Connection connection;

    public ProfesseurRepositoryBd(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Professeur professeur) {
        String sql = "INSERT INTO professeur (nom, prenom) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, professeur.getNom());
            statement.setString(2, professeur.getPrenom());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Professeur findByName(String name) {
        String sql = "SELECT * FROM professeur WHERE nom = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Professeur(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Professeur> findAll() {
        List<Professeur> professeurs = new ArrayList<>();
        String sql = "SELECT * FROM professeur";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
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
}
