package com.bookstore.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.bookstore.entities.Author;
import com.bookstore.models.AuthorModel;
import com.bookstore.views.AuthorCreateView;
import com.bookstore.views.AuthorTableView;

public class AuthorController {
  private AuthorModel model;

  private AuthorTableView view;
  private AuthorCreateView createView;

  public AuthorController() {
    model = new AuthorModel();
    view = new AuthorTableView();

    view.addCreateListener(new OpenAuthorCreateViewListener());
    updateAuthorTable();
  }

  public void updateAuthorTable() {
    List<Author> authors = model.list();
    view.updateTable(authors);
  }

  class OpenAuthorCreateViewListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      createView = new AuthorCreateView();
      createView.addCreateListener(new CreateUserListener());
    }
  }

  class CreateUserListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = createView.getName();
        String fname = createView.getFname();

        if (name.isEmpty() || fname.isEmpty()) {
          createView.throwError("Nome e Sobrenome são campos obrigatórios.");
        } else {
          Author newA = model.create(name, fname);
          System.out.println(newA.getName());
          updateAuthorTable();
          createView.close();
        }
    }
  }
}
