package com.bookstore.views.impl.book.models;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.List;
import com.bookstore.entities.Book;

public class BookTableModel extends AbstractTableModel {
    private List<Book> books;
    private String[] columnNames = { "ISBN", "Título", "Preço" };

    public BookTableModel() {
      books = new ArrayList<>();
    }

    public void updateTable(List<Book> books) {
        this.books = books;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Book author = books.get(row);
        switch (col) {
            case 0:
                return author.getIsbn();
            case 1:
                return author.getTitle();
            case 2:
                return author.getPrice();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
