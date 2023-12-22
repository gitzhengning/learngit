package com.yuming.arraylist;

public class Food {

    private String name;
    private String mesg;
    private double price;

    public Food() {
    }

    public Food(String name, String mesg, double price) {
        this.name = name;
        this.mesg = mesg;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
