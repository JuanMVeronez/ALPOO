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
        return authors;
    }

    public Author create(String name, String fname) {
        System.out.println(name);
        int id = this.repository.create(name, fname);
        Author author = this.repository.getById(id);

        return author;
    }

    public void delete(int id, boolean cascade) {
        this.repository.delete(id, cascade);
    }
}