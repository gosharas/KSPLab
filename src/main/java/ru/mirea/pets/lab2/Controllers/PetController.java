package ru.mirea.pets.lab2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.pets.lab2.Models.Pet;
import ru.mirea.pets.lab2.Services.PetService;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;


    @GetMapping("")
    public ResponseEntity<List<Pet>> getPets(){

        List<Pet> pets = petService.getPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pet> handlePet(@PathVariable int id){
        Pet pet = petService.getPet(id);
        return new ResponseEntity<>(pet,HttpStatus.OK);
    }
}
