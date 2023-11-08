package com.bookstore.views.impl.book;

import javax.swing.*;

import com.bookstore.entities.Book;
import com.bookstore.views.impl.book.models.BookTableModel;

import java.awt.*;
import java.awt.event.ActionListener;


import java.util.List;

public class BookTableView extends JPanel {
    private JButton detailsButton;
    private JButton createButton;
    private JButton deleteButton;
    private JTable table;
    private BookTableModel model;

    public BookTableView() {
        setLayout(new BorderLayout());
        
        renderTable();
        renderActionButtons();
    }

    public void renderTable() {
        model = new BookTableModel();
        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void renderActionButtons() {
        detailsButton = new JButton("Detalhes do Livro");        
        createButton = new JButton("Novo Livro");
        deleteButton = new JButton("Deletar Livro");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(detailsButton);        
        buttonPanel.add(createButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateTable(List<Book> books) {
        model.updateTable(books);
    }

    public void addDetailsListener(ActionListener listener) {
        detailsButton.addActionListener(listener);
    }

    public void addCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }
}

