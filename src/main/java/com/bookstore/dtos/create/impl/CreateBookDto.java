package com.bookstore.dtos.create.impl;

import java.util.List;

import com.bookstore.dtos.create.CreateDto;

public class CreateBookDto extends CreateDto {
    private String title;
    private String isbn;
    private int publisherId;
    private List<Integer> authorsId;
    private double price;

    public CreateBookDto() {
    }

    public CreateBookDto(
      String title,
      String isbn,
      int publisherId,
      double price,
      List<Integer> authorsId
    ) {
        this.title = title;
        this.isbn = isbn;
        this.publisherId = publisherId;
        this.authorsId = authorsId;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public int getPublisherId() {
        return this.publisherId;
    }

    public List<Integer> getAuthorsId() {
        return this.authorsId;
    }

    public double getPrice() {
        return this.price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public void setAuthorsId(List<Integer> authorsId) {
        this.authorsId = authorsId;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
