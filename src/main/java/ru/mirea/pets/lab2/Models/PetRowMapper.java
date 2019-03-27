package ru.mirea.pets.lab2.Models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetRowMapper implements RowMapper<Pet> {


    @Override
    public Pet mapRow(ResultSet row, int rowNum) throws SQLException {
        Pet pet = new Pet();
        pet.setId(row.getInt("id"));
        pet.setName(row.getString("name"));
        pet.setType(row.getString("type"));
        pet.setPrice(row.getInt("price"));
        pet.setCount(row.getInt("count"));
        return pet;
    }
}
