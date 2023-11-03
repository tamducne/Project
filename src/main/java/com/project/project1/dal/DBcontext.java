/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.project1.dal;

import java.sql.*;

/**
 *
 * @author TAMDUC
 */
public class DBcontext {
    protected Connection connection;
    protected PreparedStatement statement;
    protected  ResultSet resultSet;
    

    /**
     * get an connection
     *
     * @return connection or null
     */
    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Doctor";
            String user = "se1749";
            String password = "12345";
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error " + e.getMessage() + " at DBContext");
            return null;
        }
    }

    public static void main(String[] args) {
        DBcontext test = new DBcontext();
        
        test.connection = test.getConnection();
        System.out.println(test.connection);
    }
}
