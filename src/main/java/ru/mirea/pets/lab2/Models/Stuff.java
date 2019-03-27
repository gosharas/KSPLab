package ru.mirea.pets.lab2.Models;


import java.util.Objects;

public class Stuff implements Item {
    private int id;
    private String name;
    private String type;
    private int price;
    private int count;

    public Stuff(){

    }

    public Stuff(int id, String name, String type, int price, int count) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stuff stuff = (Stuff) o;
        return price == stuff.price &&
                count == stuff.count &&
                Objects.equals(name, stuff.name) &&
                Objects.equals(type, stuff.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, price, count);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
