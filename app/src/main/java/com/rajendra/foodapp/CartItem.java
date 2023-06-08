package com.rajendra.foodapp;

public class CartItem {
    private String itemName;
    private String itemPrice;
    private int itemQuantity;

    public CartItem(String itemName, String itemPrice,int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemQuantity() {
        return itemPrice;
    }
}

