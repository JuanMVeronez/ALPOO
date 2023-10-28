package com.bookstore;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseConnector {
    boolean connect(String jdbcUrl, String username, String password);
    boolean disconnect();
    ResultSet executeQuery(String sql) throws SQLException;
}