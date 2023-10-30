package com.bookstore.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.bookstore.MySQLConnector;
import com.bookstore.entities.Author;


public class AuthorRepository {
    private Connection connection;

    public AuthorRepository() {
        this.connection = MySQLConnector.getInstance().connection;
    }

    public List<Author> list() {
        List<Author> authors = new ArrayList<Author>();

        final String query = "SELECT * FROM Authors;";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                int authorId = rs.getInt("author_id");
                String name = rs.getString("name");
                String fname = rs.getString("fname");

                Author author = new Author(authorId, name, fname);
                authors.add(author);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return authors;
    }

    public List<Author> listByIsbn(String isbn) {
        List<Author> authors = new ArrayList<Author>();

        final String query = "SELECT A.* FROM Authors AS A "
            + "LEFT JOIN BooksAuthors AS BA ON A.author_id = BA.author_id "
            + "LEFT JOIN Books AS B on BA.isbn = B.isbn "
            + "WHERE B.isbn = ?;";
        
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, isbn);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                int authorId = rs.getInt("author_id");
                String name = rs.getString("name");
                String fname = rs.getString("fname");

                Author author = new Author(authorId, name, fname);
                authors.add(author);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return authors;
    }
}