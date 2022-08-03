package com.m2i.distributeurspringtp;


import com.m2i.distributeurspringtp.Service.ProductDaoImpl;
import com.m2i.distributeurspringtp.Service.UserService;
import com.m2i.distributeurspringtp.entity.Product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author elouf
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);
       ProductDaoImpl produitDaoImpl = ctx.getBean(ProductDaoImpl.class);
       UserService   userService =ctx.getBean(UserService.class);
     
       produitDaoImpl.create(new Product("produit1", 100, 5));
        produitDaoImpl.create(new Product("produit2", 2, 15));
        
          produitDaoImpl.findALL();
         Product prod=produitDaoImpl.findById(2L);
          System.out.println(prod  );
          
          userService.SetBalance(100);
          double a=userService.getBalance();
          System.out.println(a);
          
    }

}

// public void createProduit (Product produit){
//    
//        produitDao.save(produit);
//    } 
// 