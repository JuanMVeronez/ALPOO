package com.bookstore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bookstore.entities.Author;
import com.bookstore.models.AuthorModel;
import com.bookstore.models.PublisherModel;

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

        AuthorModel model = new AuthorModel();
        List<Author> authors = model.listAuthors();

        for(Author author : authors) {
            System.out.println(author.getName() + " " + author.getFname());
        }
    }
}
