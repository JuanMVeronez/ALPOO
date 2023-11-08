package com.bookstore.views;

import java.awt.event.ActionListener;

public interface CreateView {
  public void renderFields();
  public void renderActions();

  public void addCreateListener(ActionListener listener);
  public void throwError(String message);

  public void close();
}
