package com.bookstore.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthorCreateView extends Component {
  private JFrame frame;
  private JTextField nameField;
  private JTextField fnameField;
  private JButton createButton;

  public AuthorCreateView() {
    frame = new JFrame("Criar Autor");
    frame.setSize(400, 120);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    nameField = new JTextField(10);
    fnameField = new JTextField(20);
    createButton = new JButton("Criar Autor");

    JPanel panel = new JPanel(new GridLayout(3, 2));
    panel.add(new JLabel("Nome:"));
    panel.add(nameField);
    panel.add(new JLabel("Sobrenome:"));
    panel.add(fnameField);
    panel.add(createButton);

    frame.add(panel);
    frame.setVisible(true);
  }

  public String getName() {
    return nameField.getText().trim();
  }

  public String getFname() {
    return fnameField.getText().trim();
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
