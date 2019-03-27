package ru.mirea.pets.lab2.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.pets.lab2.Models.CartItem;
import ru.mirea.pets.lab2.Models.CartItemRowMapper;

import java.util.List;


@Transactional
@Repository
public class CartDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<CartItem> get(int id){
        String sql = "SELECT * FROM cart WHERE userID=? ;";
        RowMapper<CartItem> rowMapper = new CartItemRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper,id);
    }

    public void deleteItem(int userID, String type, int itemID){
        String sql = "DELETE FROM cart WHERE userID=? and type=? and itemID=?;";
        jdbcTemplate.update(sql, userID, type, itemID);
    }

    public void putItem(int userID, String type, int itemID){
        String sql = "INSERT INTO cart(userID,type,itemID) VALUES (?,?,?);";
        jdbcTemplate.update(sql, userID, type, itemID);
    }

    public void buyCart(int userID){
        String sql = "DELETE FROM cart WHERE userID = ? ;";
        jdbcTemplate.update(sql,userID);
    }

}
