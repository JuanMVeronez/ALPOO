package com.bookstore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bookstore.models.BookModel;

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

        BookModel bookModel = new BookModel();
        List<String> titles = bookModel.listBookTitles();

        for(String title : titles) {
            System.out.println(title);
        }
    }
}
