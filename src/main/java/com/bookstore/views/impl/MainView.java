package com.bookstore.views.impl;

import javax.swing.*;

import com.bookstore.controllers.impl.AuthorController;
import com.bookstore.controllers.impl.BookController;
import com.bookstore.controllers.impl.PublisherController;

public class MainView {
  private JFrame frame;

  private PublisherController publishers;
  private AuthorController authors;
  private BookController books;

  public MainView() {
    frame = new JFrame("Sistema da Livraria");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JTabbedPane tabbedPane = new JTabbedPane();

    books = new BookController();
    tabbedPane.addTab("Livros", books.getMain());

    publishers = new PublisherController();
    tabbedPane.addTab("Editoras", publishers.getMain());

    authors = new AuthorController();
    tabbedPane.addTab("Autores", authors.getMain());

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
