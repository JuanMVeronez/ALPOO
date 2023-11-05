package com.bookstore.views;

import javax.swing.*;

import com.bookstore.controllers.AuthorController;
import com.bookstore.controllers.BookController;
import com.bookstore.controllers.PublisherController;

public class MainView {
  private JFrame frame;

  private PublisherController publishers;
  private AuthorController authors;
  private BookController books;

  public MainView() {
    frame = new JFrame("Sistema da Livraria");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JTabbedPane tabbedPane = new JTabbedPane();

    publishers = new PublisherController();
    tabbedPane.addTab("Editoras", publishers.getMainView());

    authors = new AuthorController();
    tabbedPane.addTab("Autores", authors.getMainView());

    books = new BookController();
    tabbedPane.addTab("Livros", books.getMainView());

    tabbedPane.addChangeListener(l -> updateViews());
    frame.add(tabbedPane);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void updateViews() {
    publishers.updateTable();
    authors.updateTable();
    books.updateTable();
  }
}
