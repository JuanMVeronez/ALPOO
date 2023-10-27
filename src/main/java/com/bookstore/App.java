package com.bookstore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App 
{
    private final DatabaseConnector connector;

    public App(DatabaseConnector connector) {
        this.connector = connector;
    }
    
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/bookstore";
        String username = "admin";
        String password = "admin";

        DatabaseConnector dbConnector = new MySQLConnector(jdbcUrl, username, password);
        App app = new App(dbConnector);
        
        app.run();
        return;
    }

    public void run() {
        if (connector.connect()) {
            try {
                ResultSet resultSet = connector.executeQuery("SELECT * FROM Authors");

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String fname = resultSet.getString("fname");

                    System.out.println("Nome: " + name + ", Sobrenome: " + fname);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            connector.disconnect();
        } else {
            System.err.println("Erro ao conectar ao banco de dados MySQL.");
        }
    }
}
