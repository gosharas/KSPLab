package ru.mirea.pets.lab2.Models;

public class CartItem {
    private int userID;

    public CartItem(int userID, String type, int itemID) {
        this.userID = userID;
        this.type = type;
        this.itemID = itemID;
    }

    private String type;
    private int itemID;

    public CartItem() {
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
