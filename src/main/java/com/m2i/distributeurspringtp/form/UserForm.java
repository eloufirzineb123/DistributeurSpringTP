package com.m2i.distributeurspringtp.form;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 *
 * @author elouf
 */
  
public class UserForm {
    
    @Min(value = 1, message = "Vous devez entrer une valeur positive")
    @NotNull(message = "Vous devez entrer une valeur") 
    private double balance;
       

    public UserForm() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
      
    }

