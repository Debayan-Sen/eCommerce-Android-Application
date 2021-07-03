package com.example.c4u2.Model;

import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Cart {
    private String PName, PImage, PDescription, PPrice,PID;

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "PName='" + PName + '\'' +
                ", PImage='" + PImage + '\'' +
                ", PDescription='" + PDescription + '\'' +
                ", PPrice='" + PPrice + '\'' +
                ", PID='" + PID + '\'' +
                '}';
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPImage() {
        return PImage;
    }

    public void setPImage(String PImage) {
        this.PImage = PImage;
    }

    public String getPDescription() {
        return PDescription;
    }

    public void setPDescription(String PIDescription) {
        this.PDescription = PDescription;
    }

    public String getPPrice() {
        return PPrice;
    }

    public void setPPrice(String PPrice) {
        this.PPrice = PPrice;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }
}
