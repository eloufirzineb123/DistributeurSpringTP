package com.m2i.distributeurspringtp.controller;

import com.m2i.distributeurspringtp.Exception.BalanceInsufficientException;
import com.m2i.distributeurspringtp.Exception.NotEnoughStockException;
import com.m2i.distributeurspringtp.Repository.ProduitRepository;
import com.m2i.distributeurspringtp.Service.ProductDaoImpl;
import com.m2i.distributeurspringtp.Service.UserService;
import com.m2i.distributeurspringtp.entity.Product;
import com.m2i.distributeurspringtp.form.BuyForm;
import com.m2i.distributeurspringtp.form.UserForm;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author elouf
 */
@Controller
public class DistributeurController {
    
    
    private ProductDaoImpl  productDaoImpl;
    
    private  UserService userService;
    
    @Autowired
      public DistributeurController(ProductDaoImpl  productDaoImpl, UserService userService) {
        this.productDaoImpl= productDaoImpl;
        this.userService = userService;
    }
    
      @GetMapping("/distributeur")
    //@RequestMapping(value = "/distributeur", method = RequestMethod.GET)
    public String showDistributorPage(ModelMap model) {
        //model.addAttribute("userForm", new UserForm());

        return "distributeur";
    }
//        @RequestMapping(value="/distributeur", method=RequestMethod.GET)
//    public String showdistributeur(ModelMap model){
//        model.addAttribute("produits",  productDaoImpl.findALL());
//        model.addAttribute("balance", userService.getBalance());
//        model.addAttribute("userForm", new UserForm());
//        model.addAttribute("buyForm", new BuyForm());
//        return "distributeur";
//    }
      
      

  
    
     @RequestMapping (value="/addcredi", method =RequestMethod.POST)
    public String addcredi(@ModelAttribute("userForm")  @Valid UserForm userForm, BindingResult result, ModelMap model){
   
      if (result.hasErrors()) {
            return "distributeur";
        }
      
          userService.addBalance(userForm.getBalance());
           return "redirect:distributeur";
    }
    
    @RequestMapping (value="/achat", method =RequestMethod.POST)
    public String achProduit(@ModelAttribute ("buyForm") @Valid BuyForm buyForm, BindingResult result, ModelMap model) throws Exception  {
        
        
         if (result.hasErrors()) {
            return "distributeur";
        }

Product product = productDaoImpl.findById(buyForm.getId());
        if (product == null) {
            result.rejectValue("id", null, "Le produit n'existe pas");
            return "distributeur";
        }


         try {
             
            
            productDaoImpl.acheterProduit(product);
            return "redirect:distributeur";
        } catch (NotEnoughStockException | BalanceInsufficientException e) {
            result.rejectValue("id", null, e.getMessage());
            return "distributeur";
        } 
         
        

//        
//        if (product.getQuantity() <= 0) {
//            result.rejectValue("id", null, "Stock insuffisant");
//        }
//
//        if (userService.getBalance() < product.getPrice()) {
//            result.rejectValue("id", null, "Pas assez de crédit");
//        }
//
//        product.setQuantity(product.getQuantity() - 1);
//        userService.decreaseBalance(product.getPrice());
//        productService.save(product);
        
        
        
        


        
}

     // Equivalent de model.addAttribute("userForm", new UserForm());
    @ModelAttribute("userForm")
    public UserForm addUserForm() {
        return new UserForm();
    }

    // Equivalent de model.addAttribute("buyForm", new BuyForm());
    @ModelAttribute("buyForm")
    public BuyForm addBuyForm() {
        return new BuyForm();
    }

    @ModelAttribute("balance")
    public Double addCredit() {
        return userService.getBalance();
    }

    // Equivalent de model.addAttribute("stock", productService.findAll());
    @ModelAttribute("produits")
    public List<Product> addStock() {
        return productDaoImpl.findALL();
    }  
}