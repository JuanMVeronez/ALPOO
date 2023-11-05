package com.bookstore.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.bookstore.entities.Book;
import com.bookstore.models.BookModel;
import com.bookstore.views.book.BookDeleteView;
import com.bookstore.views.book.BookTableView;

public class BookController {
  private BookModel model;

  private BookTableView view;
  // private BookCreateView createView;
  private BookDeleteView deleteView;

  List<Book> books;

  public BookController() {
    model = new BookModel();
    view = new BookTableView();

    view.addCreateListener(new OpenAuthorCreateViewListener());
    view.addDeleteListener(new OpenAuthorDeleteViewListener());
    updateAuthorTable();
  }

  public void updateAuthorTable() {
    books = model.list();
    view.updateTable(books);
  }

  public BookTableView getMainView() {
    return view;
  }

  class OpenAuthorCreateViewListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      // createView = new BookCreateView();
      // createView.addCreateListener(new CreateAuthorListener());
    }
  }

  class OpenAuthorDeleteViewListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      deleteView = new BookDeleteView();
      deleteView.addDeleteListener(new DeleteListener());
      deleteView.setAuthorComboBox(books);
    }
  }

  // class CreateAuthorListener implements ActionListener{
  //   @Override
  //   public void actionPerformed(ActionEvent e) {
  //     String name = createView.getName();
  //     String url = createView.getUrl();

  //     if (name.isEmpty() || url.isEmpty()) {
  //       createView.throwError("Nome e Url são campos obrigatórios.");
  //     } else {
  //       model.create(name, url);
        
  //       updateAuthorTable();
  //       createView.close();
  //     }
  //   }
  // }

  class DeleteListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      Book book = deleteView.getToDelete();
      
      model.delete(book.getIsbn());
      updateAuthorTable();
      deleteView.close();
    }
  }
}
