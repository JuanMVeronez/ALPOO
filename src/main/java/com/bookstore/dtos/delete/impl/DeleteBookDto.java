package com.bookstore.dtos.delete.impl;

import com.bookstore.dtos.delete.DeleteDto;

public class DeleteBookDto extends DeleteDto {
  private String isbn;

  public DeleteBookDto() {}

  public DeleteBookDto(String isbn) {
    this.isbn = isbn;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
