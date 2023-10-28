package com.bookstore.entities;

public class Book {
    String title;
    String isbn;
    int publisherId;
    float price;

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
}
