package ru.mirea.pets.lab2.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.pets.lab2.Models.Stuff;
import ru.mirea.pets.lab2.Models.StuffRowMapper;

import java.util.List;



@Transactional
@Repository
public class StuffDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    public List<Stuff> getStuffs() {
        String sql = "SELECT * FROM stuff;";
        RowMapper<Stuff> rowMapper = new StuffRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    public Stuff getStuff(int id) {
        String sql = "SELECT * FROM stuff WHERE id = ?;";
        RowMapper<Stuff> rowMapper = new BeanPropertyRowMapper<Stuff>(Stuff.class);
        Stuff Stuff = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return Stuff;

    }


    public void addStuff(Stuff Stuff) {
        String sql = "INSERT INTO stuff(id, name, type, price, count) values (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, Stuff.getId(), Stuff.getName(), Stuff.getType(), Stuff.getPrice(), Stuff.getCount());

        sql = "SELECT id FROM stuff WHERE name=? and type=? and price=? and count=?;";
        int id = jdbcTemplate.queryForObject(sql,Integer.class, Stuff.getName(), Stuff.getType(),Stuff.getPrice(),Stuff.getCount());

        Stuff.setId(id);
    }


    public void updateStuff(Stuff Stuff) {
        String sql = "UPDATE stuff SET name=?, type=?, price=?, count=? WHERE id=?;";
        jdbcTemplate.update(sql,Stuff.getName(),Stuff.getType(), Stuff.getPrice(),Stuff.getCount(), Stuff.getId());
    }


    public void deleteStuff(int id) {
        String sql = "DELETE FROM stuffs WHERE id=?";
        jdbcTemplate.update(sql,id);
    }
}
