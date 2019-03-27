package ru.mirea.pets.lab2.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.pets.lab2.Models.Balance;

@Transactional
@Repository
public class BalanceDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public Balance get(int id) {
        String sql = "SELECT * FROM balance WHERE userID = ? ;";

        RowMapper<Balance> rowMapper = new BeanPropertyRowMapper<Balance>(Balance.class);
        Balance balance = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return balance;
    }


    public void add(Balance balance){
        String sql = "INSERT INTO balance(userID, money) VALUES(?, ?);";
        jdbcTemplate.update(sql, balance.getUserID(), balance.getMoney());
    }


    public void update(Balance balance){
        String sql = "UPDATE balance SET money=? WHERE userID = ? ;";
        jdbcTemplate.update(sql,balance.getMoney(), balance.getUserID());
    }


    public void delete(int id){
        String sql = "DELETE FROM balance WHERE userID=?;";
        jdbcTemplate.update(sql,id);
    }
}
