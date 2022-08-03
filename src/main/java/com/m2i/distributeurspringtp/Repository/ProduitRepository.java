package com.m2i.distributeurspringtp.Repository;




import com.m2i.distributeurspringtp.entity.Product;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elouf
 */

public interface ProduitRepository extends JpaRepository<Product,Long>{
     
//public List<Product> getProduitList();  
////     
//public   Product findProduit(Long id);
////     
//public  void createProduit (Product produit);
////      
//public   void acheterProduit (Product produit);
     
}
