package com.bookstore.daos;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bookstore.MySQLConnector;
import com.bookstore.entities.Book;

public class BookRepository {
    private Connection connection;

    public BookRepository() {
        this.connection = MySQLConnector.getInstance().connection;
    }
    
    public List<Book> listBooks() {

    List<Book> books = new ArrayList<Book>();

    final String query = "SELECT * FROM Books;";
    try {

        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while(rs.next()) {
            String title = rs.getString("title");
            String isbn = rs.getString("isbn");
            int publisherId = rs.getInt("publisher_id");
            float price = rs.getFloat("price");
            
            Book book = new Book(title, isbn, publisherId, price);
            books.add(book);
        }


    }catch(Exception e) {
        e.printStackTrace();
    }

    return books;
    }
}
