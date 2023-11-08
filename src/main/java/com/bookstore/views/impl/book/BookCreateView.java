package com.bookstore.views.impl.book;

import javax.swing.*;

import com.bookstore.entities.Author;
import com.bookstore.entities.Publisher;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookCreateView extends Component {
  private JFrame frame;
  private JTextField titleField;
  private JTextField isbnField;
  private JTextField priceField;
  private JComboBox<Publisher> publisherComboBox;
  
  private JList<Author> authorList;
  private DefaultListModel<Author> authorListModel;
  private JScrollPane authorScrollPane;

  private JButton createButton;

  public BookCreateView() {
    frame = new JFrame("Novo Livro");
    frame.setSize(400, 280);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    renderFields();
    
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void renderFields() {
    JPanel panel = new JPanel(new GridLayout(6, 2));
    
    titleField = new JTextField(10);
    panel.add(new JLabel("Título:"));
    panel.add(titleField);
    
    isbnField = new JTextField(20);
    panel.add(new JLabel("ISBN:"));
    panel.add(isbnField);

    priceField = new JTextField(20);
    panel.add(new JLabel("Preço:"));
    panel.add(priceField);

    publisherComboBox = new JComboBox<Publisher>();
    panel.add(new JLabel("Editora:"));
    panel.add(publisherComboBox);

    authorListModel = new DefaultListModel<Author>();
    authorList = new JList<Author>(authorListModel);
    authorScrollPane = new JScrollPane(authorList);
    authorScrollPane.setSize(200, 160);
    panel.add(new JLabel("Autores:"));
    panel.add(authorScrollPane);
    
    createButton = new JButton("Adicionar");
    panel.add(createButton);

    frame.add(panel);
  }

  public String getTitle() {
    return titleField.getText().trim();
  }

  public String getIsbn() {
    return isbnField.getText().trim();
  }

  public double getPrice() {
    try {
      return Double.parseDouble(priceField.getText().trim());
  } catch (NumberFormatException e) {
      return 0;
  }
  }

  public Publisher getPublisher() {
    return (Publisher) publisherComboBox.getSelectedItem();
  }

  public java.util.List<Author> getAuthors() {
    java.util.List<Author> selectedAuthors = new ArrayList<>();
    for (int index : authorList.getSelectedIndices()) {
        selectedAuthors.add(authorListModel.getElementAt(index));
    }
    return selectedAuthors;
  }

  public void setPublisherComboBox(java.util.List<Publisher> publishers) {
    publishers.forEach(publisher -> publisherComboBox.addItem(publisher));
  }

  public void setAuthorList(java.util.List<Author> authors) {
    authors.forEach(author -> authorListModel.addElement(author));
  }

  public void addCreateListener(ActionListener listener) {
    createButton.addActionListener(listener);
  }

  public void throwError(String message) {
    JOptionPane.showMessageDialog(frame, message, "Erro", JOptionPane.ERROR_MESSAGE);
  }

  public void close() {
    frame.dispose();
  }
  
}
