package ru.mirea.pets.lab2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.pets.lab2.Services.CartService;
import ru.mirea.pets.lab2.Models.Item;
import ru.mirea.pets.lab2.Services.PetService;
import ru.mirea.pets.lab2.Services.StuffService;

import java.util.List;




@RestController
public class CartController {

    @Autowired
    private CartService cartService;



    @GetMapping(path = "cart/user/{id}")
    public List<Item> handleCart(@PathVariable int id){
        return cartService.get(id);
    }

    @PutMapping(path = "cart/user/{userID}/pet/{id}")
    public void handleAddPet(@PathVariable int userID, @PathVariable int id){
        cartService.putItem(userID,"p", id);
    }

    @PutMapping(path = "cart/user/{userID}/stuff/{id}")
    public void handleAddStuff(@PathVariable int userID, @PathVariable int id){
        System.out.println(userID + " " + id);
        cartService.putItem(userID,"s",id);
    }

    @DeleteMapping(path = "cart/user/{userID}/pet/{id}")
    public void handleDelPet(@PathVariable int userID, @PathVariable int id){
        cartService.deleteItem(userID,"p",id);
    }

    @DeleteMapping(path = "cart/user/{userID}/stuff/{id}")
    public void handleDelStuff(@PathVariable int userID, @PathVariable int id){
        cartService.deleteItem(userID,"s",id);
    }


    @DeleteMapping(path = "cart/user/{userID}/")
    public void handleClear(@PathVariable int userID){
        cartService.clearCart(userID);
    }

    @RequestMapping(path = "cart/user/{userID}/", method = RequestMethod.POST)
    @ResponseBody
    public void buy(@PathVariable int userID){
        cartService.buyCart(userID);
    }
}

