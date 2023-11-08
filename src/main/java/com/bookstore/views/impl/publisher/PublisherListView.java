package com.bookstore.views.impl.publisher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import com.bookstore.entities.Publisher;
import com.bookstore.views.ListView;
import com.bookstore.views.impl.publisher.models.PublisherTableModel;

import java.util.List;

public class PublisherListView extends JPanel implements ListView<Publisher> {
    private JButton createButton;
    private JButton deleteButton;
    private JTable table;
    private PublisherTableModel model;

    public PublisherListView() {
        setLayout(new BorderLayout());
        
        render();
        renderActions();
    }

    @Override
    public void render() {
        model = new PublisherTableModel();
        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void renderActions() {
        createButton = new JButton("Nova Editora");
        deleteButton = new JButton("Deletar Editora");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void update(List<Publisher> authors) {
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

