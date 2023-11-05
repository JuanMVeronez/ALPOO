package com.bookstore.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.bookstore.entities.Author;
import com.bookstore.models.AuthorModel;
import com.bookstore.views.AuthorCreateView;
import com.bookstore.views.AuthorDeleteView;
import com.bookstore.views.AuthorTableView;

public class AuthorController {
  private AuthorModel model;

  private AuthorTableView view;
  private AuthorCreateView createView;
  private AuthorDeleteView deleteView;

  List<Author> authors;

  public AuthorController() {
    model = new AuthorModel();
    view = new AuthorTableView();

    view.addCreateListener(new OpenAuthorCreateViewListener());
    view.addDeleteListener(new OpenAuthorDeleteViewListener());
    updateAuthorTable();
  }

  public void updateAuthorTable() {
    authors = model.list();
    view.updateTable(authors);
  }

  class OpenAuthorCreateViewListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      createView = new AuthorCreateView();
      createView.addCreateListener(new CreateAuthorListener());
    }
  }

  class OpenAuthorDeleteViewListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      deleteView = new AuthorDeleteView();
      deleteView.addDeleteListener(new DeleteAuthorListener());
      deleteView.setAuthorComboBox(authors);
    }
  }

  class CreateAuthorListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      String name = createView.getName();
      String fname = createView.getFname();

      if (name.isEmpty() || fname.isEmpty()) {
        createView.throwError("Nome e Sobrenome são campos obrigatórios.");
      } else {
        model.create(name, fname);
        
        updateAuthorTable();
        createView.close();
      }
    }
  }

  class DeleteAuthorListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      Author author = deleteView.getAuthorToDelete();
      boolean isCascade = deleteView.getDeleteIsCascade();

      model.delete(author.getAuthorId(), isCascade);
      updateAuthorTable();
      deleteView.close();
    }
  }
}
