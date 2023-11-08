package com.bookstore.controllers.impl;

import java.util.List;

import com.bookstore.controllers.Controller;
import com.bookstore.dtos.create.impl.CreateAuthorDto;
import com.bookstore.dtos.delete.impl.DeleteAuthorDto;
import com.bookstore.entities.Author;
import com.bookstore.interfaces.CreateListener;
import com.bookstore.interfaces.DeleteListener;
import com.bookstore.models.impl.AuthorModel;
import com.bookstore.views.impl.author.AuthorCreateView;
import com.bookstore.views.impl.author.AuthorDeleteView;
import com.bookstore.views.impl.author.AuthorListView;

public class AuthorController implements Controller<AuthorListView> {
  private AuthorModel model;

  private AuthorListView view;
  private AuthorCreateView createView;
  private AuthorDeleteView deleteView;

  List<Author> authors;

  public AuthorController() {
    model = new AuthorModel();
    view = new AuthorListView();

    view.addCreateListener((e) -> openCreateView());
    view.addDeleteListener((e) -> openDeleteView());
    updateTable();
  }

  @Override
  public void updateTable() {
    authors = model.list();
    view.update(authors);
  }

  @Override
  public AuthorListView getMain() {
    return view;
  }

  @Override
  public String getTitle() {
    return "Autores";
  }

  @Override
  public void addDeleteListener(DeleteListener listener) {
    deleteView.addDeleteListener(listener);
  }

  @Override
  public void addCreateListener(CreateListener listener) {
    createView.addCreateListener(listener);
  }

  @Override
  public void openCreateView() {
    createView = new AuthorCreateView();
    addCreateListener((e) -> create());
  }

  @Override
  public void openDeleteView() {
    deleteView = new AuthorDeleteView();
    addDeleteListener((e) -> delete());
    deleteView.setAuthorComboBox(authors);
  }

  @Override
  public void create() {
    String name = createView.getName();
    String fname = createView.getFname();

    if (name.isEmpty() || fname.isEmpty()) {
      createView.throwError("Nome e Sobrenome são campos obrigatórios.");
    } else {
      model.create(new CreateAuthorDto(name, fname));
      
      updateTable();
      createView.close();
    }
  }

  @Override
  public void delete() {
    Author author = deleteView.getToDelete();
    boolean isCascade = deleteView.getDeleteIsCascade();

    model.delete(new DeleteAuthorDto(author.getAuthorId(), isCascade));
    updateTable();
    deleteView.close();
  }
}
