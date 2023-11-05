package com.bookstore.views.publisher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import com.bookstore.entities.Publisher;
import com.bookstore.views.publisher.models.PublisherTableModel;

import java.util.List;

public class PublisherTableView extends JPanel {
    private JButton createButton;
    private JButton deleteButton;
    private JTable table;
    private PublisherTableModel model;

    public PublisherTableView() {
        setLayout(new BorderLayout());
        
        renderTable();
        renderActionButtons();
    }

    public void renderTable() {
        model = new PublisherTableModel();
        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void renderActionButtons() {
        createButton = new JButton("Nova Editora");
        deleteButton = new JButton("Deletar Editora");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateTable(List<Publisher> authors) {
        model.updateTable(authors);
    }

    public void addCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }
}

