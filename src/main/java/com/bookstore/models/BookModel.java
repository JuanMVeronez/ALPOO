package com.bookstore.models;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.daos.BookRepository;
import com.bookstore.entities.Book;

public class BookModel {
    final BookRepository repository;

    public BookModel () {
        this.repository = new BookRepository();
    }

    public List<String> listBookTitles() {
        List<String> titles = new ArrayList<String>();
        List<Book> books = this.repository.listBooks();
        
        for (Book book : books) {
            titles.add(book.getTitle());
        }

        return titles;
    }
}
