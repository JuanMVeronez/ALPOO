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
}