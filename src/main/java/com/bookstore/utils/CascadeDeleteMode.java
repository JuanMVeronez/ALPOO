package com.bookstore.utils;

public class CascadeDeleteMode {  
    private String name;
    private boolean isCascade;

    public CascadeDeleteMode(String name, boolean isCascade) {
      this.name = name;
      this.isCascade = isCascade;
    }

    @Override
    public String toString() {
      return name;
    }

    public String getName() {
      return name;
    }

    public boolean getIsCascade() {
      return isCascade;
    }
  }