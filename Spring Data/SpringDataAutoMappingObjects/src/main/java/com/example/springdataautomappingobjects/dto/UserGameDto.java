package com.example.springdataautomappingobjects.dto;

public class UserGameDto {
    private String title;

    public UserGameDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
