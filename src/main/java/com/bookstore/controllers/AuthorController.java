package com.bookstore.controllers;

import java.util.List;

import com.bookstore.entities.Author;
import com.bookstore.models.AuthorModel;
import com.bookstore.views.AuthorTableView;

public class AuthorController {
    private AuthorModel model;
    private AuthorTableView view;

    public AuthorController() {
        this.model = new AuthorModel();
        this.view = new AuthorTableView();

        this.updateAuthorTable();
    }

    public void updateAuthorTable() {
        List<Author> authors = model.list();
        view.updateTable(authors);
    }
}
