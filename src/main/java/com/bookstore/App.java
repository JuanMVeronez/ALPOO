package com.bookstore;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.controllers.Controller;
import com.bookstore.controllers.impl.AuthorController;
import com.bookstore.controllers.impl.BookController;
import com.bookstore.controllers.impl.PublisherController;
import com.bookstore.services.impl.MySQLConnector;
import com.bookstore.views.impl.MainView;

import io.github.cdimascio.dotenv.Dotenv;

public class App 
{   
    public static void main(String[] args) {
        App.run();
        return;
    }

    static public void run() {
        MySQLConnector connector = MySQLConnector.getInstance();

        Dotenv dotenv = Dotenv.configure().load();

        String dbHost = dotenv.get("MYSQL_HOST_PORT");
        String dbDatabase = dotenv.get("MYSQL_DATABASE");
        String dbUser = dotenv.get("MYSQL_USER");
        String dbPassword = dotenv.get("MYSQL_PASSWORD");

        System.out.println(dbHost);
        System.out.println(dbDatabase);
        System.out.println(dbUser);
        System.out.println(dbPassword);
        
        String jdbcUrl = "jdbc:mysql://" + dbHost + "/bookstore";
        
        connector.connect(jdbcUrl, dbUser, dbPassword);

        List<Controller<?>> controllers = new ArrayList<>();

        controllers.add(new BookController());
        controllers.add(new PublisherController());
        controllers.add(new AuthorController());

        new MainView(controllers);
    }
}
