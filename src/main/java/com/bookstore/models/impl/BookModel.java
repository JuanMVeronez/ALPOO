package com.bookstore.models.impl;

import java.util.List;

import com.bookstore.daos.Repositories;
import com.bookstore.dtos.create.CreateDto;
import com.bookstore.dtos.create.impl.CreateBookDto;
import com.bookstore.dtos.delete.DeleteDto;
import com.bookstore.dtos.delete.impl.DeleteBookDto;
import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.entities.Publisher;
import com.bookstore.models.Model;

public class BookModel implements Model<Book> {
    final Repositories repositories;

    public BookModel () {
        this.repositories = new Repositories();
    }

    @Override
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

    @Override
    public Book create(CreateDto dto) {
        if (!(dto instanceof CreateBookDto)) {
            throw new IllegalArgumentException("dto must be an instance of CreateBookDto");
        }

        CreateBookDto createBookDto = (CreateBookDto) dto;

        String title = createBookDto.getTitle();
        String isbn = createBookDto.getIsbn();
        int publisherId = createBookDto.getPublisherId();
        double price = createBookDto.getPrice();
        List<Integer> authorsId = createBookDto.getAuthorsId();

        this.repositories.books.create(title, isbn, publisherId, price, authorsId);
        return this.read(isbn);
    }

    @Override
    public void delete(DeleteDto dto) {
        if (!(dto instanceof DeleteDto)) {
            throw new IllegalArgumentException("dto must be an instance of DeleteDto");
        }

        DeleteBookDto deleteDto = (DeleteBookDto) dto;
        String isbn = deleteDto.getIsbn();

        this.repositories.books.delete(isbn);
    }
}
