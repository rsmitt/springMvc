package ru.edu.site.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Book {


    @NotNull(message = "is required")
    @Min(value = 1, message = "age must be greater 0")
    private Integer id;
    @NotEmpty(message = "is required")
    @Size(min = 3, message = "cannot be less 3")
    private String title;
    @NotNull(message = "is required")
    @Min(value = 4, message = "age must be greater 4")
    private Integer year;

    public Book(int id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
