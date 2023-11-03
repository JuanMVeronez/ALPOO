package com.bookstore.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import com.bookstore.entities.Author;
import com.bookstore.views.models.AuthorTableModel;

import java.util.List;

public class AuthorTableView extends Component {
    private JFrame frame;
    private JButton createButton;
    private JTable table;
    private AuthorTableModel model;

    public AuthorTableView() {
        model = new AuthorTableModel();
        table = new JTable(model);
        frame = new JFrame("Tabela de Autores");

        createButton = new JButton("Novo Autor");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.add(createButton, BorderLayout.NORTH);
        
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public void updateTable(List<Author> authors) {
        model.updateTable(authors);
    }

    public void addCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }
}

