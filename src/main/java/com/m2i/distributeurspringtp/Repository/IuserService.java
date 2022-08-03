package com.m2i.distributeurspringtp.Repository;

/**
 *
 * @author elouf
 */
public interface IuserService {
    
   
    public double getBalance();
    
    public void SetBalance (double a);
     
    public double addBalance(Double bal);
    
    public double decreaseBalance(Double decrB);
    
    
    
}
