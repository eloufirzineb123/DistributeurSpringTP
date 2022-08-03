package com.m2i.distributeurspringtp.Exception;

/**
 *
 * @author elouf
 */
public class BalanceInsufficientException  extends Exception{

    public BalanceInsufficientException() {
        super("stock insuffisant");
    }
    
}
