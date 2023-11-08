package com.bookstore.views.impl.publisher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PublisherCreateView extends Component {
  private JFrame frame;
  private JTextField nameField;
  private JTextField urlField;
  private JButton createButton;

  public PublisherCreateView() {
    frame = new JFrame("Nova Editora");
    frame.setSize(400, 120);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    renderFields();
    
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void renderFields() {
    JPanel panel = new JPanel(new GridLayout(3, 2));
    
    nameField = new JTextField(10);
    urlField = new JTextField(20);
    
    panel.add(new JLabel("Nome:"));
    panel.add(nameField);
    panel.add(new JLabel("Url:"));
    panel.add(urlField);
    
    createButton = new JButton("Adicionar");
    panel.add(createButton);

    frame.add(panel);
  }

  public String getName() {
    return nameField.getText().trim();
  }

  public String getUrl() {
    return urlField.getText().trim();
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
