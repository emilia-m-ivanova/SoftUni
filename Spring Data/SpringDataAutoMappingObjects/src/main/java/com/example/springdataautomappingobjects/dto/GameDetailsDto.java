package com.example.springdataautomappingobjects.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameDetailsDto {
    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate date;

    public GameDetailsDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s",
                title,price,description,date);
    }
}
