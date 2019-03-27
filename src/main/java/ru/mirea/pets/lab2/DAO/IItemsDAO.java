package ru.mirea.pets.lab2.DAO;

import ru.mirea.pets.lab2.Models.Item;
import ru.mirea.pets.lab2.Models.Pet;

import java.util.List;

public interface IItemsDAO {
    List<Item> getAll();
    Pet getOne(int id);
    void add(Item item);
    void update(Item item);
    void delete(int id);
}
