package com.bookstore;

import com.bookstore.controllers.AuthorController;

public class App 
{   
    public static void main(String[] args) {
        App.run();
        return;
    }

    static public void run() {
        MySQLConnector connector = MySQLConnector.getInstance();

        String jdbcUrl = "jdbc:mysql://localhost:3306/bookstore";
        String username = "admin";
        String password = "admin";

        
        connector.connect(jdbcUrl, username, password);

        new AuthorController();
    }
}
