package com.bookstore.controllers.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.bookstore.controllers.Controller;
import com.bookstore.dtos.create.impl.CreateBookDto;
import com.bookstore.dtos.delete.impl.DeleteBookDto;
import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.entities.Publisher;
import com.bookstore.interfaces.CreateListener;
import com.bookstore.interfaces.DeleteListener;
import com.bookstore.models.impl.AuthorModel;
import com.bookstore.models.impl.BookModel;
import com.bookstore.models.impl.PublisherModel;
import com.bookstore.views.book.BookCreateView;
import com.bookstore.views.book.BookDeleteView;
import com.bookstore.views.book.BookDetailsView;
import com.bookstore.views.book.BookTableView;

public class BookController implements Controller<BookTableView> {
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
    view.addCreateListener((e) -> openCreateView());
    view.addDeleteListener((e) -> openDeleteView());
    view.addDetailsListener(e -> {
      detailsView = new BookDetailsView(this);
      detailsView.setBookComboBox(books);
    });
    updateTable();
  }

  @Override
  public void updateTable() {
    books = model.list();
    view.updateTable(books);
  }

  public Book getBookDetails(Book book) {
    return model.read(book.getIsbn());
  }

  @Override
  public BookTableView getMain() {
    return view;
  }

  @Override
  public void addCreateListener(CreateListener listener) {
    createView.addCreateListener(listener);
  }

  @Override
  public void addDeleteListener(DeleteListener listener) {
    deleteView.addDeleteListener(listener);
  }

  @Override
  public void openCreateView() {
    createView = new BookCreateView();
    createView.addCreateListener((e) -> create());
    createView.setAuthorList(authorModel.list());
    createView.setPublisherComboBox(publisherModel.list());
  }

  @Override
  public void openDeleteView() {
    deleteView = new BookDeleteView();
    deleteView.addDeleteListener((e) -> delete());
    deleteView.setBookComboBox(books);
  }

  @Override
  public void create() {
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
      model.create(new CreateBookDto(title, isbn, publisher.getPublisherId(), price, authorsId));
      
      updateTable();
      createView.close();
    }
  }

  @Override
  public void delete() {
    Book book = deleteView.getToDelete();
      
    model.delete(new DeleteBookDto(book.getIsbn()));
    updateTable();
    deleteView.close();
  }
}
