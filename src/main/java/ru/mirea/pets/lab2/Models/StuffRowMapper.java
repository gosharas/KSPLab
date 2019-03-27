package ru.mirea.pets.lab2.Models;

import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class StuffRowMapper implements RowMapper<Stuff> {
    @Override
    public Stuff mapRow(ResultSet row, int rowNum) throws SQLException {
        Stuff stuff = new Stuff();
        stuff.setId(row.getInt("id"));
        stuff.setName(row.getString("name"));
        stuff.setType(row.getString("type"));
        stuff.setPrice(row.getInt("price"));
        stuff.setCount(row.getInt("count"));
        return stuff;
    }
}
