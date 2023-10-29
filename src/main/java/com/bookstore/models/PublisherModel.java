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

    public List<String> listPublisherNames() {
        List<String> names = new ArrayList<String>();
        List<Publisher> publishers = this.repository.list();
        
        for (Publisher publisher : publishers) {
            names.add(publisher.getName());
        }

        return names;
    }
}