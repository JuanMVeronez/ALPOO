package com.bookstore.views.impl.book;

import javax.swing.*;

import com.bookstore.entities.Book;
import com.bookstore.views.ListView;
import com.bookstore.views.impl.book.models.BookTableModel;

import java.awt.*;
import java.awt.event.ActionListener;


import java.util.List;

public class BookListView extends JPanel implements ListView<Book> {
    private JButton detailsButton;
    private JButton createButton;
    private JButton deleteButton;
    private JTable table;
    private BookTableModel model;

    public BookListView() {
        setLayout(new BorderLayout());
        
        render();
        renderActions();
    }

    @Override
    public void render() {
        model = new BookTableModel();
        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void renderActions() {
        detailsButton = new JButton("Detalhes do Livro");        
        createButton = new JButton("Novo Livro");
        deleteButton = new JButton("Deletar Livro");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(detailsButton);        
        buttonPanel.add(createButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void update(List<Book> books) {
        model.updateTable(books);
    }

    public void addDetailsListener(ActionListener listener) {
        detailsButton.addActionListener(listener);
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

