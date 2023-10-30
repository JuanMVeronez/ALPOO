package com.bookstore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.entities.Publisher;
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
        List<Integer> authors = new ArrayList<Integer>();
        authors.addAll(Arrays.asList(2597));
        Book book = model.create("getTitle", "aisdunasidano", 201, 1.234, authors);

        System.out.println(book.getIsbn() + book.getPrice() + book.getPublisherId() + book.getTitle() + book.getPublisher().getName());
    }
}
