package com.bookstore.views.impl.author;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import com.bookstore.entities.Author;
import com.bookstore.views.ListView;
import com.bookstore.views.impl.author.models.AuthorTableModel;

import java.util.List;

public class AuthorListView extends JPanel implements ListView<Author> {
    private JButton createButton;
    private JButton deleteButton;
    private JTable table;
    private AuthorTableModel model;

    public AuthorListView() {
        setLayout(new BorderLayout());
        
        render();
        renderActions();
    }

    @Override
    public void render() {
        model = new AuthorTableModel();
        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void renderActions() {
        createButton = new JButton("Novo Autor");
        deleteButton = new JButton("Deletar Autor");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void update(List<Author> authors) {
        model.updateTable(authors);
    }

    @Override
    public void addCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    @Override
    public void addDeleteListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }
}

