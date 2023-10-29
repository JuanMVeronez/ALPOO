package com.bookstore.models;

import java.util.List;

import com.bookstore.daos.AuthorRepository;
import com.bookstore.entities.Author;

public class AuthorModel {
    final AuthorRepository repository;
    
    public AuthorModel() {
        this.repository = new AuthorRepository();
    }

    public List<Author> listAuthors() {
        List<Author> authors = this.repository.list();
        return authors;
    }
}