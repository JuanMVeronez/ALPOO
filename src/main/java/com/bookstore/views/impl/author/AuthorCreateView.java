package com.bookstore.views.impl.author;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthorCreateView extends Component {
  private JFrame frame;
  private JTextField nameField;
  private JTextField fnameField;
  private JButton createButton;

  public AuthorCreateView() {
    frame = new JFrame("Novo Autor");
    frame.setSize(400, 120);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    renderFields();
    
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void renderFields() {
    JPanel panel = new JPanel(new GridLayout(3, 2));
    
    nameField = new JTextField(10);
    fnameField = new JTextField(20);
    
    panel.add(new JLabel("Nome:"));
    panel.add(nameField);
    panel.add(new JLabel("Sobrenome:"));
    panel.add(fnameField);
    
    createButton = new JButton("Adicionar");
    panel.add(createButton);

    frame.add(panel);
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
