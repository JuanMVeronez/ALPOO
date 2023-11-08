package com.bookstore.dtos.delete.impl;

import com.bookstore.dtos.delete.DeleteDto;

public class DeleteAuthorDto extends DeleteDto {
  private int id;
  private boolean cascade;

  public DeleteAuthorDto() {}

  public DeleteAuthorDto(int id, boolean cascade) {
    this.id = id;
    this.cascade = cascade;
  }

  public int getId() {
    return this.id;
  }

  public boolean getCascade() {
    return this.cascade;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setCascade(boolean cascade) {
    this.cascade = cascade;
  }
}
