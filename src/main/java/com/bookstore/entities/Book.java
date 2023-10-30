package com.bookstore.entities;

import java.util.List;

public class Book {
    String title;
    String isbn;
    int publisherId;
    float price;

    Publisher publisher;
    List<Author> authors;

    public Book(
        String title,
        String isbn,
        int publisherId,
        float price
    ) {
        this.title = title;
        this.isbn = isbn;
        this.publisherId = publisherId;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public float getPrice() {
        return price;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
