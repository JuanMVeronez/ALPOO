package com.bookstore.views.impl.author;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.bookstore.entities.Author;

public class AuthorDeleteView extends Component {
  private JFrame frame;
  private JButton deleteButton;
  private JComboBox<Author> authorComboBox;
  private JComboBox<DeleteMode> deleteOptionComboBox;

  public AuthorDeleteView() {
    frame = new JFrame("Deletar Autor");
    frame.setSize(400, 120);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    renderFields();

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void renderFields() {
    JPanel panel = new JPanel(new GridLayout(3, 2));

    authorComboBox = new JComboBox<Author>();
    deleteOptionComboBox = new JComboBox<DeleteMode>();
    deleteButton = new JButton("Deletar Autor");

    panel.add(new JLabel("Selecione o Autor:"));
    panel.add(authorComboBox);

    panel.add(new JLabel("Opção de Exclusão:"));
    panel.add(deleteOptionComboBox);

    deleteOptionComboBox.addItem(new DeleteMode("Excluir Autor", false));
    deleteOptionComboBox.addItem(new DeleteMode("Excluir Autor e Obras", true));

    panel.add(deleteButton);

    frame.add(panel);
  }

  public Author getToDelete() {
    return (Author) authorComboBox.getSelectedItem();
  }

  public boolean getDeleteIsCascade() {
    DeleteMode mode = (DeleteMode) deleteOptionComboBox.getSelectedItem();
    return mode.isCascade;
  }
  
  public void addDeleteListener(ActionListener listener) {
    deleteButton.addActionListener(listener);
  }

  public void setAuthorComboBox(List<Author> authors) {
    authors.forEach(author -> authorComboBox.addItem(author));
  }

  public void close() {
    frame.dispose();
  }

  class DeleteMode {
    private String name;
    private boolean isCascade;

    public DeleteMode(String name, boolean isCascade) {
      this.name = name;
      this.isCascade = isCascade;
    }

    @Override
    public String toString() {
      return name;
    }
  }
}
