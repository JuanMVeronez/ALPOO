package com.bookstore.models.impl;

import java.util.List;

import com.bookstore.daos.PublisherRepository;
import com.bookstore.dtos.create.CreateDto;
import com.bookstore.dtos.create.impl.CreatePublisherDto;
import com.bookstore.dtos.delete.DeleteDto;
import com.bookstore.dtos.delete.impl.DeletePublisherDto;
import com.bookstore.entities.Publisher;
import com.bookstore.models.Model;

public class PublisherModel implements Model<Publisher> {
    final PublisherRepository repository;
    
    public PublisherModel() {
        this.repository = new PublisherRepository();
    }

    @Override
    public List<Publisher> list() {
        List<Publisher> publishers = this.repository.list();
        return publishers;
    }

    @Override
    public Publisher create(CreateDto dto) {
        if (!(dto instanceof CreatePublisherDto)) {
            throw new IllegalArgumentException("dto must be an instance of CreatePublisherDto");
        }

        CreatePublisherDto createPublisherDto = (CreatePublisherDto) dto;
        String name = createPublisherDto.getName();
        String url = createPublisherDto.getUrl();

        int id = this.repository.create(name, url);
        Publisher publisher = this.repository.getById(id);

        return publisher;
    }

    @Override
    public void delete(DeleteDto dto) {
        if (!(dto instanceof DeletePublisherDto)) {
            throw new IllegalArgumentException("dto must be an instance of DeleteDto");
        }

        DeletePublisherDto deletePublisherDto = (DeletePublisherDto) dto;
        int id = deletePublisherDto.getId();
        boolean cascade = deletePublisherDto.getCascade();

        this.repository.delete(id, cascade);
    }
}