package ru.mirea.pets.lab2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.pets.lab2.Models.Stuff;
import ru.mirea.pets.lab2.Services.StuffService;

import java.util.List;

@RestController
public class StuffController {

    @Autowired
    private StuffService stuffService;

    @RequestMapping(path = "stuff", method = RequestMethod.GET)
    @ResponseBody
    public List<Stuff> handleStuff(){
        List<Stuff> stuff = stuffService.getStuff();
        return stuff;
    }

    @RequestMapping(path = "stuff/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Stuff handleGetOne(@PathVariable int id){

        return stuffService.getOne(id);
    }


}
