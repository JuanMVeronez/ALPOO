package com.bookstore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.models.AuthorModel;
import com.bookstore.models.BookModel;
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

        BookModel model = new BookModel();
        Book book = model.bookDetails("Test");

        System.out.println(book.getAuthors().get(0).getName() + " " + book.getPublisher().getName());
        
    }
}
