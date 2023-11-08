package com.bookstore.views.impl.book;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.bookstore.entities.Book;
import com.bookstore.views.DeleteView;

public class BookDeleteView extends Component implements DeleteView<Book> {
  private JFrame frame;
  private JPanel panel;
  private JButton deleteButton;
  private JComboBox<Book> bookComboBox;
  
  public BookDeleteView() {
    frame = new JFrame("Deletar Livro");
    frame.setSize(400, 80);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    panel = new JPanel(new GridLayout(2, 2));

    renderFields();
    renderAction();

    frame.add(panel);

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  @Override
  public void renderFields() {
    bookComboBox = new JComboBox<Book>();

    panel.add(new JLabel("Selecione o Livro:"));
    panel.add(bookComboBox);
  }

  @Override
  public void renderAction() {
    deleteButton = new JButton("Deletar Livro");
    panel.add(deleteButton);
  }
  
  @Override
  public void addDeleteListener(ActionListener listener) {
    deleteButton.addActionListener(listener);
  }

  @Override
  public void close() {
    frame.dispose();
  }

  public Book getToDelete() {
    return (Book) bookComboBox.getSelectedItem();
  }

  public void setBookComboBox(List<Book> books) {
    books.forEach(book -> bookComboBox.addItem(book));
  }
}
