package com.bookstore.views.impl.publisher;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.bookstore.entities.Publisher;
import com.bookstore.utils.CascadeDeleteMode;
import com.bookstore.views.DeleteView;

public class PublisherDeleteView extends Component implements DeleteView<Publisher> {
  private JFrame frame;
  private JPanel panel;
  private JButton deleteButton;
  private JComboBox<Publisher> bookComboBox;
  private JComboBox<CascadeDeleteMode> deleteOptionComboBox;

  public PublisherDeleteView() {
    frame = new JFrame("Deletar Editora");
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
    bookComboBox = new JComboBox<Publisher>();
    deleteOptionComboBox = new JComboBox<CascadeDeleteMode>();

    panel.add(new JLabel("Selecione a Editora:"));
    panel.add(bookComboBox);

    panel.add(new JLabel("Opção de Exclusão:"));
    panel.add(deleteOptionComboBox);

    deleteOptionComboBox.addItem(new CascadeDeleteMode("Excluir Editora", false));
    deleteOptionComboBox.addItem(new CascadeDeleteMode("Excluir Editora e Obras", true));
  }

  @Override
  public void renderAction() {
    deleteButton = new JButton("Deletar Editora");
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

  public Publisher getToDelete() {
    return (Publisher) bookComboBox.getSelectedItem();
  }

  public boolean getDeleteIsCascade() {
    CascadeDeleteMode mode = (CascadeDeleteMode) deleteOptionComboBox.getSelectedItem();
    return mode.getIsCascade();
  }

  public void setBookComboBox(List<Publisher> publishers) {
    publishers.forEach(publisher -> bookComboBox.addItem(publisher));
  }
}
