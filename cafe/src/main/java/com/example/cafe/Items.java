package com.example.cafe;

import java.util.ArrayList;

public class Items {
    //representing our coffee
    private String name;
    private double price;
    private double quantity;
    private double amount;
    private String note;
    public static ArrayList<Items> list = new ArrayList<>(); //here

    public Items(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.amount = price * quantity;
    }
    public Items(String name, int price,int quantity, String note) {
        this.name = name;
        this.price = price;
        this.note=note;
        this.quantity=quantity;
        this.amount = price * quantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}


