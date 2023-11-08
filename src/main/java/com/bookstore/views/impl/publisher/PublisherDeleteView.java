package com.bookstore.views.impl.publisher;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.bookstore.entities.Publisher;

public class PublisherDeleteView extends Component {
  private JFrame frame;
  private JButton deleteButton;
  private JComboBox<Publisher> bookComboBox;
  private JComboBox<DeleteMode> deleteOptionComboBox;

  public PublisherDeleteView() {
    frame = new JFrame("Deletar Editora");
    frame.setSize(400, 120);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    renderFields();

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void renderFields() {
    JPanel panel = new JPanel(new GridLayout(3, 2));

    bookComboBox = new JComboBox<Publisher>();
    deleteOptionComboBox = new JComboBox<DeleteMode>();
    deleteButton = new JButton("Deletar Editora");

    panel.add(new JLabel("Selecione a Editora:"));
    panel.add(bookComboBox);

    panel.add(new JLabel("Opção de Exclusão:"));
    panel.add(deleteOptionComboBox);

    deleteOptionComboBox.addItem(new DeleteMode("Excluir Editora", false));
    deleteOptionComboBox.addItem(new DeleteMode("Excluir Editora e Obras", true));

    panel.add(deleteButton);

    frame.add(panel);
  }

  public Publisher getToDelete() {
    return (Publisher) bookComboBox.getSelectedItem();
  }

  public boolean getDeleteIsCascade() {
    DeleteMode mode = (DeleteMode) deleteOptionComboBox.getSelectedItem();
    return mode.isCascade;
  }
  
  public void addDeleteListener(ActionListener listener) {
    deleteButton.addActionListener(listener);
  }

  public void setBookComboBox(List<Publisher> publishers) {
    publishers.forEach(publisher -> bookComboBox.addItem(publisher));
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
