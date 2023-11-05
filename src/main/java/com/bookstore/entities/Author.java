package com.bookstore.entities;

public class Author {
    int authorId;
    String name;
    String fname;

    public Author(int authorId, String name, String fname) {
        this.authorId = authorId;
        this.name = name;
        this.fname = fname;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getFname();
    }

    @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Author author = (Author) obj;
    return authorId == author.authorId;
  }

  @Override
  public int hashCode() {
    return authorId;
  }
}
