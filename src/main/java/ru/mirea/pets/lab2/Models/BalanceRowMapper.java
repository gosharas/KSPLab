package ru.mirea.pets.lab2.Models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceRowMapper implements RowMapper<Balance> {


    @Override
    public Balance mapRow(ResultSet row, int rowNum) throws SQLException {
        Balance balance = new Balance();
        balance.setUserID(row.getInt("userID"));
        balance.setMoney(row.getInt("money"));
        return balance;
    }
}
