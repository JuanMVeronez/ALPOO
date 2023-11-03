package com.bookstore.views;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.bookstore.entities.Author;
import com.bookstore.views.models.AuthorTableModel;

import java.util.List;

public class AuthorTableView {
    private JFrame frame;
    private JTable table;
    private AuthorTableModel model;

    public AuthorTableView() {
        model = new AuthorTableModel();
        table = new JTable(model);
        frame = new JFrame("Tabela de Autores");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.pack();
        frame.setVisible(true);
    }

    public void updateTable(List<Author> authors) {
        model.updateTable(authors);
    }
}

