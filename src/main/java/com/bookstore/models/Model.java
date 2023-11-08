package com.bookstore.models;

import java.util.List;

import com.bookstore.dtos.create.CreateDto;
import com.bookstore.dtos.delete.DeleteDto;

public interface Model<T> {
  public List<T> list();
  public T create(CreateDto dto);
  public void delete(DeleteDto dto);
}
