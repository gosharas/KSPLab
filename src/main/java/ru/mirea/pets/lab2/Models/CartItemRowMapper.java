package ru.mirea.pets.lab2.Models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItemRowMapper implements RowMapper<CartItem> {
    @Override
    public CartItem mapRow(ResultSet row, int i) throws SQLException {
        CartItem cartItem = new CartItem();
        cartItem.setUserID(row.getInt("userID"));
        cartItem.setType(row.getString("type"));
        cartItem.setItemID(row.getInt("itemID"));
        return cartItem;
    }
}
