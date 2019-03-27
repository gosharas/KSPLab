package ru.mirea.pets.lab2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.pets.lab2.DAO.BalanceDAO;
import ru.mirea.pets.lab2.DAO.CartDAO;
import ru.mirea.pets.lab2.Models.CartItem;
import ru.mirea.pets.lab2.Models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class CartService {
    @Autowired
    CartDAO cartDAO;

    @Autowired
    PetService petService;

    @Autowired
    StuffService stuffService;

    @Autowired
    BalanceService balanceService;


    public List<Item> get(int userID){
        List<CartItem> rowCart = cartDAO.get(userID);
        List<Item> realCart = new ArrayList<>();
        for (CartItem var:rowCart){
            if (var.getType().equals("s")){
                realCart.add(stuffService.getOne(var.getItemID()));
            } else if (var.getType().equals("p")){
                realCart.add(petService.getPet(var.getItemID()));
            }
        }
        return realCart;
    }


    public void putItem(int userID,String type, int itemID){
        cartDAO.putItem(userID, type, itemID);
    }

    public void deleteItem(int userID,String type, int itemID){
        cartDAO.deleteItem(userID, type, itemID);
    }

    public boolean buyCart(int userID){
        List<Item> curCart = this.get(userID);
        int sum = 0;
        for (Item var:curCart){
            sum += var.getPrice();
        }
        if (balanceService.getBalance(userID) < sum){
            return false;
        }
        boolean f = balanceService.buy(userID,sum);
        if (f){
            cartDAO.buyCart(userID);
        }
        return f;
    }

    public void clearCart(int userID) {
        cartDAO.buyCart(userID);
    }


}
