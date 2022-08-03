package com.m2i.distributeurspringtp.Service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.m2i.distributeurspringtp.Repository.IuserService;

/**
 *
 * @author elouf
 */

@Service
@Transactional
public class UserService implements IuserService {

    
 private double balance;
    
    @Override
    public double getBalance() {
    return   this.balance;
    }

    @Override
    public void SetBalance( double a) {
     this.balance=a;
    }

    @Override
    public double addBalance(Double bal) {
        return this.balance +=bal;
    }

    @Override
    public double decreaseBalance(Double decrB) {
        return this.balance -=decrB;
    }
    
}
