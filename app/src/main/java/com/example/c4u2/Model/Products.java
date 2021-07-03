package com.example.c4u2.Model;

public class Products {
    String NAME;
    String DESCRIPTION;
    String PRICE;
    String IMAGE;
    String PID;




    public Products() {
    }

    @Override
    public String toString() {
        return "Products{" +
                "NAME='" + NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", PRICE='" + PRICE + '\'' +
                ", IMAGE='" + IMAGE + '\'' +
                ", PID='" + PID + '\'' +
                '}';
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }
}
