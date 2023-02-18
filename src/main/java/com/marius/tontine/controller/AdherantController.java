package com.marius.tontine.controller;

import com.marius.tontine.dbHelper.Connexion;

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
}
