package com.m2i.distributeurspringtp.Service;

import com.m2i.distributeurspringtp.Exception.BalanceInsufficientException;
import com.m2i.distributeurspringtp.Exception.NotEnoughStockException;
import com.m2i.distributeurspringtp.Repository.IuserService;
import com.m2i.distributeurspringtp.entity.Product;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.m2i.distributeurspringtp.Repository.ProduitRepository;

/**
 *
 * @author elouf
 */
@Service
@Transactional
public class ProductDaoImpl {

    private final ProduitRepository produitDao;
    private final IuserService userService;

    
    @Autowired
    public ProductDaoImpl(ProduitRepository produitDao, IuserService userService) {
        this.produitDao = produitDao;
        this.userService = userService;
    }
    
   
    
    
  public List <Product> findALL(){
        return produitDao.findAll();
    }

    public Product findById(Long id){
        return produitDao.findById(id).orElse(null);
    }

    public void create(Product produit) {
        produitDao.save(produit);
    }

    
    public void acheterProduit(Product product ) throws NotEnoughStockException, BalanceInsufficientException, Exception  {
        
        if(product.getQuantite()<=0 ){
            throw new NotEnoughStockException();
        }
        if(userService.getBalance()<product.getPrix()){
            throw new BalanceInsufficientException();
        }
        if( product ==null) 
        {
            throw new Exception(" le produit n'existe pas");
        }
        else{
        product.setQuantite(product.getQuantite()-1);
        userService.SetBalance(userService.getBalance()-product.getPrix());
        create(product);}
       
       
    }
    
   
}
