package com.marius.tontine.controller;

import com.marius.tontine.dbHelper.Connexion;
import com.marius.tontine.modele.Adherant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdherantController {

    Connection con;
    PreparedStatement preparedStatement;

    public ResultSet getData() throws SQLException, ClassNotFoundException {
        con =Connexion.getConect();
        String query ="SELECT * FROM `adherant`";
        preparedStatement = con.prepareStatement(query);

        return preparedStatement.executeQuery();
    }
    public boolean deleteAdherant(int id) throws SQLException, ClassNotFoundException {
        String qr = "DELETE FROM `adherant` WHERE id = ?";
        con = Connexion.getConect();
        preparedStatement = con.prepareStatement(qr);
        preparedStatement.setInt(1,id);
        return preparedStatement.execute();
    }
    public static int addAdherant(Adherant adh) throws ClassNotFoundException, SQLException {
    int isDone = 0;
        try {
            String query = "INSERT INTO adherant(nom,prenom,date_naissance,date_adhesion,contact,email,sexe) "
                    + "VALUES(?,?,?,?,?,?,?)";


            Connection con = Connexion.getConect();
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, adh.getNom());
            preparedStatement.setString(2,adh.getPrenom());
            preparedStatement.setDate(3, adh.getDateNaissance());
            preparedStatement.setDate(4, adh.getDateAdhesion());
            preparedStatement.setInt(5, adh.getContact());
            preparedStatement.setString(6,adh.getEmail());
            preparedStatement.setString(7,adh.getSexe().toUpperCase());

            isDone =  preparedStatement.executeUpdate();
        }
        catch(Exception e) {
            System.err.println("Erreur ! ");
            System.err.println(e.getMessage());
        }


        return isDone;
    }
}
