package com.bookstore.entities;

public class Author {
    int authorId;
    String name;
    String fname;

    public Author(int authorId, String name, String fname) {
        this.authorId = authorId;
        this.name = name;
        this.fname = fname;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }
}
