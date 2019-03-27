package ru.mirea.pets.lab2.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.pets.lab2.Models.Pet;
import ru.mirea.pets.lab2.Models.PetRowMapper;

import java.util.List;

@Transactional
@Repository
public class PetDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Pet> getPets() {
        String sql = "SELECT * FROM pets;";

        RowMapper<Pet> rowMapper = new PetRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    public Pet getPet(int id) {
        String sql = "SELECT * FROM pets WHERE id = ?;";
        RowMapper<Pet> rowMapper = new BeanPropertyRowMapper<Pet>(Pet.class);
        Pet pet = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return pet;

    }


    public void addPet(Pet pet) {
        String sql = "INSERT INTO pets(id, name, type, price, count) values (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, pet.getId(), pet.getName(), pet.getType(), pet.getPrice(), pet.getCount());

        sql = "SELECT id FROM pets WHERE name=? and type=? and price=? and count=?;";
        int id = jdbcTemplate.queryForObject(sql,Integer.class, pet.getName(), pet.getType(),pet.getPrice(),pet.getCount());

        pet.setId(id);
    }


    public void updatePet(Pet pet) {
        String sql = "UPDATE pets SET name=?, type=?, price=?, count=? WHERE id=?;";
        jdbcTemplate.update(sql,pet.getName(),pet.getType(), pet.getPrice(),pet.getCount(), pet.getId());
    }


    public void deletePet(int id) {
        String sql = "DELETE FROM pets WHERE id=?";
        jdbcTemplate.update(sql,id);
    }
}
