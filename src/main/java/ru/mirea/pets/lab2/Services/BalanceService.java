package ru.mirea.pets.lab2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.pets.lab2.DAO.BalanceDAO;
import ru.mirea.pets.lab2.Models.Balance;

@Service
public class BalanceService {
    @Autowired
    BalanceDAO balanceDAO;

    public int getBalance(int userID){
        return balanceDAO.get(userID).getMoney();
    }

    public boolean buy(int userID, int sum){
        if (balanceDAO.get(userID).getMoney() >= sum){
            Balance newBalance = new Balance(userID, balanceDAO.get(userID).getMoney() - sum);
            balanceDAO.update(newBalance);
            return true;
        } else{
            return false;
        }
    }



}
