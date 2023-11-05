package com.bookstore.views.book;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.bookstore.entities.Book;

public class BookDeleteView extends Component {
  private JFrame frame;
  private JButton deleteButton;
  private JComboBox<Book> authorComboBox;
  
  public BookDeleteView() {
    frame = new JFrame("Deletar Livro");
    frame.setSize(400, 80);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    renderFields();

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void renderFields() {
    JPanel panel = new JPanel(new GridLayout(2, 2));

    authorComboBox = new JComboBox<Book>();
    deleteButton = new JButton("Deletar Livro");

    panel.add(new JLabel("Selecione o Livro:"));
    panel.add(authorComboBox);

    panel.add(deleteButton);

    frame.add(panel);
  }

  public Book getToDelete() {
    return (Book) authorComboBox.getSelectedItem();
  }
  
  public void addDeleteListener(ActionListener listener) {
    deleteButton.addActionListener(listener);
  }

  public void setAuthorComboBox(List<Book> books) {
    books.forEach(book -> authorComboBox.addItem(book));
  }

  public void close() {
    frame.dispose();
  }
}
