package com.bookstore.services.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.services.DatabaseConnector;

public class MySQLConnector implements DatabaseConnector {
    private static MySQLConnector instance;
    public Connection connection;

    public static MySQLConnector getInstance() {
        if (instance == null) {
            instance = new MySQLConnector();
        }
        return instance;
    }

    @Override
    public boolean connect(String jdbcUrl, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conexão com o banco de dados MySQL estabelecida com sucesso!");
            
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados MySQL: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean disconnect() {
        try {
            this.connection.close();
            System.out.println("Conexão com o banco de dados MySQL fechada com sucesso!");
            
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao desconectar banco de dados SQL: " + e.getMessage());
            return false;
        }    
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }
}