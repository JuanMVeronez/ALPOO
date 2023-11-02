package com.bookstore.daos;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                double price = rs.getDouble("price");
                
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
                double price = rs.getDouble("price");
                
                return new Book(title, isbn, publisherId, price);
            }


        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void create(
        String title,
        String isbn,
        int publisherId,
        double price,
        List<Integer> authorsId
    ) {
        final String authorsQ = "INSERT INTO BooksAuthors VALUES (?, ?, ?);";
        final String bookQ = "INSERT INTO Books VALUES (?, ?, ?, ?);";
        
        try {
            connection.setAutoCommit(false);

            try (PreparedStatement stm = connection.prepareStatement(bookQ, Statement.RETURN_GENERATED_KEYS)) {
                stm.setString(1, title);
                stm.setString(2, isbn);
                stm.setInt(3, publisherId);
                stm.setDouble(4, price);
                
                stm.executeUpdate();
    
                for (int i = 0; i < authorsId.size(); i++) {
                    int authorId = authorsId.get(i);
    
                    try (PreparedStatement authorsStm = connection.prepareStatement(authorsQ, Statement.RETURN_GENERATED_KEYS)) {
                        authorsStm.setString(1, isbn);
                        authorsStm.setInt(2, authorId);
                        authorsStm.setInt(3, i + 1);
                        
                        authorsStm.executeUpdate();
                    }
                }
    
                connection.commit();
            } catch(Exception e) {
                e.printStackTrace();
                connection.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(String isbn) {
        final String query = "CALL deleteBook(?);";

        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, isbn);
            
            stm.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
