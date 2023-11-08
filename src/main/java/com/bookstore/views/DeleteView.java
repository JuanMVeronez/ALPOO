package com.bookstore.views;

import java.awt.event.ActionListener;

public interface DeleteView<T> {
  public void renderFields();
  public void renderAction();
  public void addDeleteListener(ActionListener listener);
  public void close();
}
