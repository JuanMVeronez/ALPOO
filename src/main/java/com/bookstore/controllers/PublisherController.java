package com.bookstore.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.bookstore.entities.Publisher;
import com.bookstore.models.PublisherModel;
import com.bookstore.views.publisher.PublisherCreateView;
import com.bookstore.views.publisher.PublisherDeleteView;
import com.bookstore.views.publisher.PublisherTableView;

public class PublisherController {
  private PublisherModel model;

  private PublisherTableView view;
  private PublisherCreateView createView;
  private PublisherDeleteView deleteView;

  List<Publisher> authors;

  public PublisherController() {
    model = new PublisherModel();
    view = new PublisherTableView();

    view.addCreateListener(new OpenAuthorCreateViewListener());
    view.addDeleteListener(new OpenAuthorDeleteViewListener());
    updateTable();
  }

  public void updateTable() {
    authors = model.list();
    view.updateTable(authors);
  }

  public PublisherTableView getMainView() {
    return view;
  }

  class OpenAuthorCreateViewListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      createView = new PublisherCreateView();
      createView.addCreateListener(new CreateListener());
    }
  }

  class OpenAuthorDeleteViewListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      deleteView = new PublisherDeleteView();
      deleteView.addDeleteListener(new DeleteListener());
      deleteView.setBookComboBox(authors);
    }
  }

  class CreateListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      String name = createView.getName();
      String url = createView.getUrl();

      if (name.isEmpty() || url.isEmpty()) {
        createView.throwError("Nome e Url são campos obrigatórios.");
      } else {
        model.create(name, url);
        
        updateTable();
        createView.close();
      }
    }
  }

  class DeleteListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      Publisher author = deleteView.getToDelete();
      boolean isCascade = deleteView.getDeleteIsCascade();

      model.delete(author.getPublisherId(), isCascade);
      updateTable();
      deleteView.close();
    }
  }
}
