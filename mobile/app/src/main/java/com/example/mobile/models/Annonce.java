package com.example.mobile.models;

public class Annonce {

    private String category;
    private String title;
    private String description;
    private int price;
    private String number;

    public Annonce(String category, String title, String description, int price, String number) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getNumber() {
        return number;
    }
}
