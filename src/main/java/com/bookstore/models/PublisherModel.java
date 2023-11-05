package com.bookstore.models;

import java.util.List;

import com.bookstore.daos.PublisherRepository;
import com.bookstore.entities.Publisher;

public class PublisherModel {
    final PublisherRepository repository;
    
    public PublisherModel() {
        this.repository = new PublisherRepository();
    }

    public List<Publisher> list() {
        List<Publisher> publishers = this.repository.list();
        return publishers;
    }

    public Publisher create(String name, String url) {
        int id = this.repository.create(name, url);
        Publisher publisher = this.repository.getById(id);

        return publisher;
    }

    public void delete(int id, boolean cascade) {
        this.repository.delete(id, cascade);
    }
}