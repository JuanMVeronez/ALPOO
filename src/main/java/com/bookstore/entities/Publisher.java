package com.bookstore.entities;

public class Publisher {
    int publisherId;
    String name;
    String url;

    public Publisher(
        int publisherId,
        String name,
        String url
    ) {
        this.publisherId = publisherId;
        this.name = name;
        this.url = url;
    }

    public Publisher(
        String name,
        String url
    ) {
        this.name = name;
        this.url = url;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Publisher publisher = (Publisher) obj;
    return publisherId == publisher.publisherId;
  }

  @Override
  public int hashCode() {
    return publisherId;
  }
}
