package com.bookstore.dtos.create.impl;

import com.bookstore.dtos.create.CreateDto;

public class CreatePublisherDto extends CreateDto {
  private String name;
  private String url;

  public CreatePublisherDto() {
  }

  public CreatePublisherDto(String name, String url) {
    this.name = name;
    this.url = url;
  }

  public String getName() {
    return this.name;
  }

  public String getUrl() {
    return this.url;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
