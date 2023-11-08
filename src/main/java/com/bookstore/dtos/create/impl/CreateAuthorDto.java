package com.bookstore.dtos.create.impl;

import com.bookstore.dtos.create.CreateDto;

public class CreateAuthorDto extends CreateDto {
    private String name;
    private String fname;

    public CreateAuthorDto() {
    }

    public CreateAuthorDto(String name, String fname) {
        this.name = name;
        this.fname = fname;
    }

    public String getName() {
        return this.name;
    }

    public String getFname() {
        return this.fname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
