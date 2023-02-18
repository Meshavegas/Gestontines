package com.marius.tontine.dbHelper;

import java.sql.*;

public class Connexion {
    static Connection connection ;
    private static String url = "jdbc:mysql://localhost:3306/tontine";
    private static String USERNAME = "";
    private static String PASSWORD = "";


    public static Connection getConect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");


        connection = DriverManager.getConnection(url,USERNAME,PASSWORD);
        return connection;
    }


}
