package com.bookstore.views.impl.book;

import javax.swing.*;

import com.bookstore.entities.Author;
import com.bookstore.entities.Publisher;
import com.bookstore.views.CreateView;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookCreateView extends Component implements CreateView {
  private JFrame frame;
  private JPanel panel;
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

    panel = new JPanel(new GridLayout(6, 2));
    
    renderFields();
    renderActions();

    frame.add(panel);
    
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  @Override
  public void renderFields() {
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
  }

  @Override
  public void renderActions() {
    createButton = new JButton("Adicionar");
    panel.add(createButton);
  }

  @Override
  public void addCreateListener(ActionListener listener) {
    createButton.addActionListener(listener);
  }

  @Override
  public void throwError(String message) {
    JOptionPane.showMessageDialog(frame, message, "Erro", JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void close() {
    frame.dispose();
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
}
