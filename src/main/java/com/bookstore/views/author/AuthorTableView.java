package com.bookstore.views.author;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import com.bookstore.entities.Author;
import com.bookstore.views.author.models.AuthorTableModel;

import java.util.List;

public class AuthorTableView extends JPanel {
    private JButton createButton;
    private JButton deleteButton;
    private JTable table;
    private AuthorTableModel model;

    public AuthorTableView() {
        setLayout(new BorderLayout());
        
        renderTable();
        renderActionButtons();
    }

    public void renderTable() {
        model = new AuthorTableModel();
        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void renderActionButtons() {
        createButton = new JButton("Novo Autor");
        deleteButton = new JButton("Deletar Autor");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateTable(List<Author> authors) {
        model.updateTable(authors);
    }

    public void addCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }
}

