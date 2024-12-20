package com.repository.bd;

import com.entity.Cours;
import com.entity.Classe;
import com.entity.Professeur;
import com.entity.Niveau;
import com.core.bd.Database;
import com.core.bd.DatabaseImpl;
import com.repository.CoursRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursRepositoryBd implements CoursRepository {

    private DatabaseImpl database;

    public CoursRepositoryBd() {
        this.database = new DatabaseImpl();  
    }

    @Override
    public void save(Cours cours) {
        String sql = "INSERT INTO cours (nom, professeur_id) VALUES (?, ?)";
        try {
            database.initPreparedStatement(sql);  
            database.statement.setString(1, cours.getNom());  
            database.statement.setInt(2, cours.getProfesseur().getId());  
            int rowsAffected = database.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cours ajouté avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.CloseConnection();
        }
    }
    
    @Override
    public List<Cours> findByNiveau(Niveau niveau) {
        List<Cours> result = new ArrayList<>();
        String sql = "SELECT * FROM cours c " +
                     "JOIN cours_classes cc ON c.id = cc.cours_id " +
                     "JOIN classes cl ON cl.id = cc.classe_id " +
                     "WHERE cl.niveau = ?";
        try {
            database.initPreparedStatement(sql);
            database.statement.setString(1, niveau.getNom()); 
            ResultSet rs = database.executeSelect();
            while (rs.next()) {
                Cours cours = new Cours();
                cours.setNom(rs.getString("nom"));
    
                int professeurId = rs.getInt("professeur_id");
                Professeur professeur = findProfesseurById(professeurId);
                cours.setProfesseur(professeur);
    
                List<Classe> classes = findClassesForCours(cours);
                cours.setClasses(classes);
    
                result.add(cours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.CloseConnection();
        }
        return result;
    }
    
    private Professeur findProfesseurById(int id) {
        String sql = "SELECT * FROM professeur WHERE id = ?";
        try {
            database.initPreparedStatement(sql);
            PreparedStatement statement = (PreparedStatement) database.statement; 
            statement.setInt(1, id);
            ResultSet rs = database.executeSelect();
            if (rs.next()) {
                return new Professeur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    private List<Classe> findClassesForCours(Cours cours) {
        List<Classe> classes = new ArrayList<>();
        String sql = "SELECT cl.id, cl.nom, cl.niveau FROM classes cl " +
                     "JOIN cours_classes cc ON cl.id = cc.classe_id " +
                     "WHERE cc.cours_id = ?";
        try {
            database.initPreparedStatement(sql);
            PreparedStatement statement = (PreparedStatement) database.statement; 
            statement.setInt(1, cours.getId());  
            ResultSet rs = database.executeSelect();
            while (rs.next()) {
                Classe classe = new Classe();
                classe.setId(rs.getInt("id"));
                classe.setNom(rs.getString("nom"));
                Niveau niveau = new Niveau(rs.getString("niveau"));
                classe.setNiveau(niveau);
                classes.add(classe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }
}
