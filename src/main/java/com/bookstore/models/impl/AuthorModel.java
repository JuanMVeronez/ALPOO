package com.bookstore.models.impl;

import java.util.List;

import com.bookstore.daos.AuthorRepository;
import com.bookstore.dtos.create.CreateDto;
import com.bookstore.dtos.create.impl.CreateAuthorDto;
import com.bookstore.dtos.delete.DeleteDto;
import com.bookstore.dtos.delete.impl.DeleteAuthorDto;
import com.bookstore.entities.Author;
import com.bookstore.models.Model;

public class AuthorModel implements Model<Author> {
    final AuthorRepository repository;
    
    public AuthorModel() {
        this.repository = new AuthorRepository();
    }

    @Override
    public List<Author> list() {
        List<Author> authors = this.repository.list();
        return authors;
    }

    @Override
    public Author create(CreateDto dto) {
        if (!(dto instanceof CreateAuthorDto)) {
            throw new IllegalArgumentException("dto must be an instance of CreateAuthorDto");
        }

        CreateAuthorDto createAuthorDto = (CreateAuthorDto) dto;

        String name = createAuthorDto.getName();
        String fname = createAuthorDto.getFname();

        int id = this.repository.create(name, fname);
        Author author = this.repository.getById(id);

        return author;
    }

    @Override
    public void delete(DeleteDto dto) {
        if (!(dto instanceof DeleteAuthorDto)) {
            throw new IllegalArgumentException("dto must be an instance of DeleteAuthorDto");
        }

        DeleteAuthorDto deleteAuthorDto = (DeleteAuthorDto) dto;
        int id = deleteAuthorDto.getId();
        boolean cascade = deleteAuthorDto.getCascade();
        
        this.repository.delete(id, cascade);
    }
}