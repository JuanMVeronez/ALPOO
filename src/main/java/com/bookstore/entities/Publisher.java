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
}
