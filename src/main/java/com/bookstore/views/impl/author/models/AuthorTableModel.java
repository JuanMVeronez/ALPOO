package com.bookstore.views.impl.author.models;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.List;
import com.bookstore.entities.Author;

public class AuthorTableModel extends AbstractTableModel {
    private List<Author> authors;
    private String[] columnNames = { "Id", "Nome", "Sobrenome" };

    public AuthorTableModel() {
      authors = new ArrayList<>();
    }

    public void updateTable(List<Author> authors) {
        this.authors = authors;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return authors.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Author author = authors.get(row);
        switch (col) {
            case 0:
                return author.getAuthorId();
            case 1:
                return author.getName();
            case 2:
                return author.getFname();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
