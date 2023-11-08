package com.bookstore.views.impl;

import java.util.List;

import javax.swing.*;

import com.bookstore.controllers.Controller;

public class MainView {
  private JFrame frame;

  private List<Controller<?>> controllers;

  public MainView(List<Controller<?>> controllers) {
    this.controllers = controllers;

    frame = new JFrame("Sistema da Livraria");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JTabbedPane tabbedPane = new JTabbedPane();

    controllers.forEach(c -> tabbedPane.addTab(c.getTitle(), (JPanel) c.getMain()));

    tabbedPane.addChangeListener(l -> updateViews());
    
    frame.add(tabbedPane);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void updateViews() {
    controllers.forEach(c -> c.updateTable());
  }
}
