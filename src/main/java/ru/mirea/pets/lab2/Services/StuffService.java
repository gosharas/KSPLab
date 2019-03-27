package ru.mirea.pets.lab2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.pets.lab2.DAO.StuffDAO;
import ru.mirea.pets.lab2.Models.Stuff;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class StuffService {
    @Autowired
    StuffDAO stuffDAO;

    public Stuff getOne(int id){
        return stuffDAO.getStuff(id);
    }

    public List<Stuff> getStuff(){
        return stuffDAO.getStuffs();
    }

    public void buyStuff(int id){
        Stuff stuff = stuffDAO.getStuff(id);
        stuff.setCount(stuff.getCount() - 1);
        stuffDAO.updateStuff(stuff);
    }

}
