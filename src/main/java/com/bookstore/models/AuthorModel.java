package com.bookstore.models;

import java.util.List;

import com.bookstore.daos.AuthorRepository;
import com.bookstore.entities.Author;

public class AuthorModel {
    final AuthorRepository repository;
    
    public AuthorModel() {
        this.repository = new AuthorRepository();
    }

    public List<Author> list() {
        List<Author> authors = this.repository.list();
        authors.forEach(author -> System.out.println(author.getName()));
        return authors;
    }

    public Author create(String name, String url) {
        int id = this.repository.create(name, url);
        Author author = this.repository.getById(id);

        return author;
    }

    public void delete(int id, boolean cascade) {
        this.repository.delete(id, cascade);
    }
}