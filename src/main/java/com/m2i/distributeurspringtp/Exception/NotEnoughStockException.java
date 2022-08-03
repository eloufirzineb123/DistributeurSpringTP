package com.m2i.distributeurspringtp.Exception;

/**
 *
 * @author elouf
 */
public class NotEnoughStockException extends Exception{
    
    public NotEnoughStockException() {
        super("La produit n'est plus en stock");
    }
}
