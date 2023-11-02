package com.bookstore.models;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.daos.PublisherRepository;
import com.bookstore.entities.Publisher;

public class PublisherModel {
    final PublisherRepository repository;
    
    public PublisherModel() {
        this.repository = new PublisherRepository();
    }

    public List<String> listNames() {
        List<String> names = new ArrayList<String>();
        List<Publisher> publishers = this.repository.list();
        
        for (Publisher publisher : publishers) {
            names.add(publisher.getName());
        }

        return names;
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