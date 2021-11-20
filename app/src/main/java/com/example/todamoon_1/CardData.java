package com.example.todamoon_1;

public class CardData {
    public final String restaurant;
    public final String shortDescription;
    public final String longDescription;
    public final String location;
    public final String category;
    public final int image;
    public final int image_icon;

    public CardData(String restaurant, String shortDescription, String longDescription, String location, String category, int image, int image_icon) {
        this.restaurant = restaurant;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.location = location;
        this.category = category;
        this.image = image;
        this.image_icon = image_icon;
    }
}
