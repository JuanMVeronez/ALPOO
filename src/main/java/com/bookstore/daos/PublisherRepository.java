package com.bookstore.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.MySQLConnector;
import com.bookstore.entities.Publisher;

public class PublisherRepository {
    private Connection connection;

    public PublisherRepository() {
        this.connection = MySQLConnector.getInstance().connection;
    }

    public List<Publisher> list() {
        List<Publisher> publishers = new ArrayList<Publisher>();

        final String query = "SELECT * FROM Publishers;";
        try {

            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while(rs.next()) {
                int publisherId = rs.getInt("publisher_id");
                String name = rs.getString("name");
                String url = rs.getString("url");
                
                Publisher publisher = new Publisher(publisherId, name, url);
                publishers.add(publisher);
            }


        }catch(Exception e) {
            e.printStackTrace();
        }

        return publishers;
    }

    public Publisher getById(int id) {
        final String query = "SELECT * FROM Publishers " 
            + "WHERE publisher_id = ?;";
    
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            if(rs.next()) {
                String name = rs.getString("name");
                String url = rs.getString("url");
                
                return new Publisher(id, name, url);
            }


        }catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Publisher getByIsbn(String isbn) {
        final String query = "SELECT P.* FROM Publishers AS P " 
            + "LEFT JOIN Books AS B ON P.publisher_id = B.publisher_id " 
            + "WHERE B.isbn = ?;";
    
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, isbn);

            ResultSet rs = stm.executeQuery();

            if(rs.next()) {
                int publisherId = rs.getInt("publisher_id");
                String name = rs.getString("name");
                String url = rs.getString("url");
                
                return new Publisher(publisherId, name, url);
            }


        }catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int create(String name, String url) {
        final String query = "INSERT INTO Publishers (name, url) VALUES (?, ?);";
        
        try (PreparedStatement stm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, name);
            stm.setString(2, url);
            
            stm.executeUpdate();

            ResultSet generatedKeys = stm.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }    
        } catch(Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void delete(int id, boolean cascade) {
        final String query = "CALL deletePublisher(?, ?);";

        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, id);
            stm.setBoolean(2, cascade);

            stm.executeQuery();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}