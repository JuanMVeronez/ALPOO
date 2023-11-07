package com.bookstore.views.book;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemListener;

import javax.swing.*;

import com.bookstore.controllers.impl.BookController;
import com.bookstore.entities.Author;
import com.bookstore.entities.Book;

public class BookDetailsView extends Component {
  private JPanel mainPanel;
  private JComboBox<Book> bookComboBox;
  private JTextArea bookDetailsTextArea;
  private BookController controller;

  public BookDetailsView(BookController controller) {
    this.controller = controller;

    JFrame frame = new JFrame("Detalhes do Livro");
    frame.setSize(400, 280);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    mainPanel = new JPanel(new GridLayout(2, 1));
    frame.add(mainPanel);

    renderSelectBook();
    renderBookDetailsTextArea();

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void renderSelectBook() {
    JPanel panel = new JPanel(new GridLayout(1, 2));

    bookComboBox = new JComboBox<Book>();
    bookComboBox.addItemListener(new SelectBookChangeListener());
    panel.add(new JLabel("Selecione o Livro:"));
    panel.add(bookComboBox);


    mainPanel.add(panel);
  }

  public void renderBookDetailsTextArea() {
    bookDetailsTextArea = new JTextArea(10, 30);
    bookDetailsTextArea.setEditable(false);

    JScrollPane scrollPane = new JScrollPane(bookDetailsTextArea);
    mainPanel.add(scrollPane);
  }

  public void displayBookDetails(Book book) {
    if (book != null) {
      String details = "Título: " + book.getTitle() + "\n";
      details += "ISBN: " + book.getIsbn() + "\n";
      details += "Editora: " + book.getPublisher()  + "\n";
      details += "Preço: R$ " + book.getPrice() + "\n";
      
      List<Author> authors = book.getAuthors();
      if (authors != null && !authors.isEmpty()) {
        List<String> authorNames = new ArrayList<>();
        authors.forEach(author -> authorNames.add(author.toString()));
        String authorsString = String.join(", ", authorNames);
        details += "Autores: " + authorsString + "\n";
      } else {
        details += "Autores: Não disponíveis\n";
      }
      

      bookDetailsTextArea.setText(details);
    } else {
      bookDetailsTextArea.setText("");
    }
  }

  public void setBookComboBox(List<Book> books) {
    books.forEach(book -> bookComboBox.addItem(book));
  }

  class SelectBookChangeListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e) {
      if (e.getStateChange() == ItemEvent.SELECTED) {
        Book book = controller.getBookDetails((Book) bookComboBox.getSelectedItem());
        System.out.println(book);
        displayBookDetails(book);
      }
    }
  }
}
