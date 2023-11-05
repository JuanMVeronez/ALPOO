package com.bookstore.models;

import java.util.List;

import com.bookstore.daos.Repositories;
import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.entities.Publisher;

public class BookModel {
    final Repositories repositories;

    public BookModel () {
        this.repositories = new Repositories();
    }

    public List<Book> list() {
        List<Book> books = this.repositories.books.list();

        return books;
    }

    public Book read(String isbn) {
        Book book = this.repositories.books.getByIsbn(isbn);

        Publisher publisher = this.repositories.publishers.getByIsbn(isbn);
        book.setPublisher(publisher);
        
        List<Author> authors = this.repositories.authors.listByIsbn(isbn);
        book.setAuthors(authors);

        return book;
    }

    public Book create(
        String title,
        String isbn,
        int publisherId,
        double price,
        List<Integer> authorsId
    ) {
        this.repositories.books.create(title, isbn, publisherId, price, authorsId);
        return this.read(isbn);
    }

    public void delete(String isbn) {
        this.repositories.books.delete(isbn);
    }
}
