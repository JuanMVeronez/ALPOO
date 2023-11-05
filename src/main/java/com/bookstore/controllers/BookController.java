package com.bookstore.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.entities.Publisher;
import com.bookstore.models.AuthorModel;
import com.bookstore.models.BookModel;
import com.bookstore.models.PublisherModel;
import com.bookstore.views.book.BookCreateView;
import com.bookstore.views.book.BookDeleteView;
import com.bookstore.views.book.BookDetailsView;
import com.bookstore.views.book.BookTableView;

public class BookController {
  private BookModel model = new BookModel();
  private AuthorModel authorModel = new AuthorModel();
  private PublisherModel publisherModel = new PublisherModel();

  private BookTableView view;
  private BookCreateView createView;
  private BookDeleteView deleteView;  
  private BookDetailsView detailsView;

  List<Book> books;

  public BookController() {
    view = new BookTableView();
    view.addCreateListener(new OpenAuthorCreateViewListener());
    view.addDeleteListener(new OpenAuthorDeleteViewListener());
    view.addDetailsListener(e -> {
      detailsView = new BookDetailsView(this);
      detailsView.setBookComboBox(books);
    });
    updateTable();
  }

  public void updateTable() {
    books = model.list();
    view.updateTable(books);
  }

  public BookTableView getMainView() {
    return view;
  }

  class OpenAuthorCreateViewListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      createView = new BookCreateView();
      createView.addCreateListener(new CreateListener());
      createView.setAuthorList(authorModel.list());
      createView.setPublisherComboBox(publisherModel.list());
    }
  }

  class OpenAuthorDeleteViewListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      deleteView = new BookDeleteView();
      deleteView.addDeleteListener(new DeleteListener());
      deleteView.setBookComboBox(books);
    }
  }

  class CreateListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      String title = createView.getTitle();
      String isbn = createView.getIsbn();
      double price = createView.getPrice();
      Publisher publisher = createView.getPublisher();
      List<Author> authors = createView.getAuthors();

      if (title.isEmpty() || isbn.isEmpty() || price == 0) {
        createView.throwError("Todos os campos de texto são obrigatórios.");
      } else if (publisher == null) {
        createView.throwError("Editora é um campo obrigatório.");
      } else if (authors.isEmpty()) {
        createView.throwError("Autor é um campo obrigatório.");
      } else {
        List<Integer> authorsId = authors.stream().map(author -> author.getAuthorId()).collect(Collectors.toList());
        model.create(title, isbn, publisher.getPublisherId(), price, authorsId);
        
        updateTable();
        createView.close();
      }
    }
  }

  class DeleteListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      Book book = deleteView.getToDelete();
      
      model.delete(book.getIsbn());
      updateTable();
      deleteView.close();
    }
  }

  public Book getBookDetails(Book book) {
    return model.read(book.getIsbn());
  }
}
