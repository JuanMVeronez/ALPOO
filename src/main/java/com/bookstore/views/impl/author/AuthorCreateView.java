package com.bookstore.views.impl.author;

import javax.swing.*;

import com.bookstore.views.CreateView;

import java.awt.*;
import java.awt.event.ActionListener;

public class AuthorCreateView extends Component implements CreateView {
  private JFrame frame;
  private JPanel panel;
  private JTextField nameField;
  private JTextField fnameField;
  private JButton createButton;

  public AuthorCreateView() {
    frame = new JFrame("Novo Autor");
    frame.setSize(400, 120);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    panel = new JPanel(new GridLayout(3, 2));

    renderFields();
    renderActions();
    
    frame.add(panel);

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  @Override
  public void renderFields() {
    nameField = new JTextField(10);
    fnameField = new JTextField(20);
    
    panel.add(new JLabel("Nome:"));
    panel.add(nameField);
    panel.add(new JLabel("Sobrenome:"));
    panel.add(fnameField);
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

  public String getName() {
    return nameField.getText().trim();
  }

  public String getFname() {
    return fnameField.getText().trim();
  }
}
