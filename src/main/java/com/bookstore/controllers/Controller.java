package com.bookstore.controllers;

import com.bookstore.interfaces.CreateListener;
import com.bookstore.interfaces.DeleteListener;

public interface Controller<T> {
  void updateTable();
  T getMain();
  String getTitle();

  void addCreateListener(CreateListener listener);
  void addDeleteListener(DeleteListener listener);

  void openCreateView();
  void openDeleteView();

  void create();
  void delete();
}
