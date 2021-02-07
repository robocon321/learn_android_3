package com.example.learnandroid3.utils;

public class Item {
    private int image;
    private String desciption;

    public Item(int image, String desciption) {
        this.image = image;
        this.desciption = desciption;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
