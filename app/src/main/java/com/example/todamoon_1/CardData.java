package com.example.todamoon_1;

public class CardData {
    public final String restaurant;
    public final String shortDescription;
    public final String longDescription;
    public final String category;
    public final int image;

    public CardData(String restaurant, String shortDescription, String longDescription, String category, int image) {
        this.restaurant = restaurant;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.category = category;
        this.image = image;
    }
}
