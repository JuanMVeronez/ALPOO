package com.bookstore.views.book;

import javax.swing.*;

import com.bookstore.entities.Book;
import com.bookstore.views.book.models.BookTableModel;

import java.awt.*;
import java.awt.event.ActionListener;


import java.util.List;

public class BookTableView extends JPanel {
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
        createButton = new JButton("Novo Livro");
        deleteButton = new JButton("Deletar Livro");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateTable(List<Book> books) {
        model.updateTable(books);
    }

    public void addCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }
}

