package com.repository.bd;

import com.core.bd.DatabaseImpl;
import com.entity.Classe;
import com.repository.ClasseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClasseRepositoryBd implements ClasseRepository {

    private DatabaseImpl database;

    public ClasseRepositoryBd() {
        this.database = new DatabaseImpl();
    }

    @Override
    public void save(Classe classe) {
        String sql = "INSERT INTO classes (nom) VALUES (?)"; 
        try {
            database.initPreparedStatement(sql);
            database.statement.setString(1, classe.getNom());
            int rowsAffected = database.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Classe ajoutée avec succès !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.CloseConnection();
        }
    }

    @Override
    public List<Classe> findAll() {
        List<Classe> classeList = new ArrayList<>();
        String sql = "SELECT * FROM classes"; 
        try {
            database.initPreparedStatement(sql);
            ResultSet rs = database.executeSelect();
            while (rs.next()) {
                Classe classe = new Classe();  
                classe.setId(rs.getInt("id")); 
                classe.setNom(rs.getString("nom"));
                classeList.add(classe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.CloseConnection();
        }
        return classeList;
    }
    
}
