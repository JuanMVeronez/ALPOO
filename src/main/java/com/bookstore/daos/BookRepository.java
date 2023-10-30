package com.bookstore.daos;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bookstore.MySQLConnector;
import com.bookstore.entities.Book;

public class BookRepository {
    private Connection connection;

    public BookRepository() {
        this.connection = MySQLConnector.getInstance().connection;
    }
    
    public List<Book> list() {
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


        } catch(Exception e) {
            e.printStackTrace();
        }

        return books;
    }
 
    public Book getByIsbn(String isbn) {
        final String query = "SELECT * FROM Books "
            + "WHERE isbn = ?;";
        
        try {

            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, isbn);

            ResultSet rs = stm.executeQuery();

            if(rs.next()) {
                String title = rs.getString("title");
                int publisherId = rs.getInt("publisher_id");
                float price = rs.getFloat("price");
                
                return new Book(title, isbn, publisherId, price);
            }


        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
