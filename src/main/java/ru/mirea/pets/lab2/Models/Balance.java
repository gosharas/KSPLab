package ru.mirea.pets.lab2.Models;

public class Balance {
    private int userID;
    private int money;

    public Balance(int userID, int money) {
        this.userID = userID;
        this.money = money;
    }

    public Balance() {
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
