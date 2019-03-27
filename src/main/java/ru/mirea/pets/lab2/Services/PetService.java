package ru.mirea.pets.lab2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.pets.lab2.DAO.PetDAO;
import ru.mirea.pets.lab2.Models.Pet;

import java.util.List;


@Service
public class PetService {
    @Autowired
    PetDAO petDAO;


    public Pet getPet(int id){
        return petDAO.getPet(id);
    }

    public List<Pet> getPets(){
        return petDAO.getPets();
    }

    public void buyPet(int id){
        Pet pet = petDAO.getPet(id);
        pet.setCount(pet.getCount() - 1);
        petDAO.updatePet(pet);
    }
}
