package com.bookstore.views.impl.publisher.models;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.List;
import com.bookstore.entities.Publisher;

public class PublisherTableModel extends AbstractTableModel {
    private List<Publisher> publishers;
    private String[] columnNames = { "Id", "Nome", "Url" };

    public PublisherTableModel() {
      publishers = new ArrayList<>();
    }

    public void updateTable(List<Publisher> publishers) {
        this.publishers = publishers;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return publishers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Publisher publisher = publishers.get(row);
        switch (col) {
            case 0:
                return publisher.getPublisherId();
            case 1:
                return publisher.getName();
            case 2:
                return publisher.getUrl();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
