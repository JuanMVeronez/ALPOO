package com.bookstore.views.impl.author;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.bookstore.dtos.delete.impl.DeleteAuthorDto;
import com.bookstore.entities.Author;
import com.bookstore.utils.CascadeDeleteMode;
import com.bookstore.views.DeleteView;

public class AuthorDeleteView extends Component implements DeleteView<DeleteAuthorDto>  {
  private JFrame frame;
  private JPanel panel;
  private JButton deleteButton;
  private JComboBox<Author> authorComboBox;
  private JComboBox<CascadeDeleteMode> deleteOptionComboBox;

  public AuthorDeleteView() {
    frame = new JFrame("Deletar Autor");
    frame.setSize(400, 120);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    panel = new JPanel(new GridLayout(3, 2));
    renderFields();
    renderAction();
    frame.add(panel);

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  @Override
  public void renderFields() {
    authorComboBox = new JComboBox<Author>();
    deleteOptionComboBox = new JComboBox<CascadeDeleteMode>();    

    panel.add(new JLabel("Selecione o Autor:"));
    panel.add(authorComboBox);

    panel.add(new JLabel("Opção de Exclusão:"));
    panel.add(deleteOptionComboBox);

    deleteOptionComboBox.addItem(new CascadeDeleteMode("Excluir Autor", false));
    deleteOptionComboBox.addItem(new CascadeDeleteMode("Excluir Autor e Obras", true));
  }

  @Override
  public void renderAction() {
    deleteButton = new JButton("Deletar Autor");
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

  public Author getToDelete() {
    return (Author) authorComboBox.getSelectedItem();
  }

  public boolean getDeleteIsCascade() {
    CascadeDeleteMode mode = (CascadeDeleteMode) deleteOptionComboBox.getSelectedItem();
    return mode.getIsCascade();
  }

  public void setAuthorComboBox(List<Author> authors) {
    authors.forEach(author -> authorComboBox.addItem(author));
  }
}
