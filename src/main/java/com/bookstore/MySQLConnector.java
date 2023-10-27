package com.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnector implements DatabaseConnector {
    private Connection connection;
    private final String jdbcUrl;
    private final String username;
    private final String password;

    
    public MySQLConnector(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean connect() {
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