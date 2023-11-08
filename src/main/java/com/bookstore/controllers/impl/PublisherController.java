package com.bookstore.controllers.impl;

import java.util.List;

import com.bookstore.controllers.Controller;
import com.bookstore.dtos.create.impl.CreatePublisherDto;
import com.bookstore.dtos.delete.impl.DeletePublisherDto;
import com.bookstore.entities.Publisher;
import com.bookstore.interfaces.CreateListener;
import com.bookstore.interfaces.DeleteListener;
import com.bookstore.models.impl.PublisherModel;
import com.bookstore.views.impl.publisher.PublisherCreateView;
import com.bookstore.views.impl.publisher.PublisherDeleteView;
import com.bookstore.views.impl.publisher.PublisherListView;

public class PublisherController implements Controller<PublisherListView> {
  private PublisherModel model;
  private PublisherListView view;
  private PublisherCreateView createView;
  private PublisherDeleteView deleteView;

  List<Publisher> publishers;

  public PublisherController() {
    model = new PublisherModel();
    view = new PublisherListView();

    view.addCreateListener((e) -> openCreateView());
    view.addDeleteListener((e) -> openDeleteView());
    updateTable();
  }

  @Override
  public void updateTable() {
    publishers = model.list();
    view.update(publishers);
  }

  @Override
  public PublisherListView getMain() {
    return view;
  }

  @Override
  public String getTitle() {
    return "Editoras";
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
    createView = new PublisherCreateView();
    addCreateListener((e) -> create());
  }

  @Override
  public void openDeleteView() {
    deleteView = new PublisherDeleteView();
    addDeleteListener((e) -> delete());
    deleteView.setBookComboBox(publishers);
  }

  @Override
  public void create() {
    String name = createView.getName();
    String url = createView.getUrl();

    if (name.isEmpty() || url.isEmpty()) {
      createView.throwError("Nome e URL são campos obrigatórios.");
    } else {
      model.create(new CreatePublisherDto(name, url));

      updateTable();
      createView.close();
    }
  }

  @Override
  public void delete() {
    Publisher publisher = deleteView.getToDelete();
    boolean isCascade = deleteView.getDeleteIsCascade();

    model.delete(new DeletePublisherDto(publisher.getPublisherId(), isCascade));
    updateTable();
    deleteView.close();
  }
}
