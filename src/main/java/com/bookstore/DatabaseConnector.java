package com.bookstore;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseConnector {
    boolean connect();
    boolean disconnect();
    ResultSet executeQuery(String sql) throws SQLException;
}