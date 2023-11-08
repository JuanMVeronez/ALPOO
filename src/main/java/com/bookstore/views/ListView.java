package com.bookstore.views;

import java.awt.event.ActionListener;
import java.util.List;

public interface ListView<T> {
  public void render();
  public void renderActions();
  public void update(List<T> list);
  public void addCreateListener(ActionListener listener);
  public void addDeleteListener(ActionListener listener);
}
