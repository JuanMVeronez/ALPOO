package com.bookstore.views;

import javax.swing.*;

import com.bookstore.controllers.AuthorController;
import com.bookstore.controllers.BookController;
import com.bookstore.controllers.PublisherController;
import com.bookstore.views.author.AuthorTableView;
import com.bookstore.views.book.BookTableView;
import com.bookstore.views.publisher.PublisherTableView;

public class MainView {
  private JFrame frame;

  public MainView() {
    frame = new JFrame("Sistema da Livraria");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JTabbedPane tabbedPane = new JTabbedPane();

    PublisherTableView publishersView = new PublisherController().getMainView();
    tabbedPane.addTab("Editoras", publishersView);

    AuthorTableView authorsView = new AuthorController().getMainView();
    tabbedPane.addTab("Autores", authorsView);

    BookTableView booksView = new BookController().getMainView();
    tabbedPane.addTab("Livros", booksView);


    frame.add(tabbedPane);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
