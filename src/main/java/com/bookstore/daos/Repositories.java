package com.bookstore.daos;

public class Repositories {
    final public AuthorRepository authors;
    final public BookRepository books;
    final public PublisherRepository publishers;

    public Repositories() {
        this.authors = new AuthorRepository();
        this.books = new BookRepository();
        this.publishers = new PublisherRepository();
    }
}
