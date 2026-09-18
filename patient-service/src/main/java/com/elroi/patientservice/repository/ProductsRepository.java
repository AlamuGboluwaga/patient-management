package com.elroi.patientservice.repository;

import com.elroi.patientservice.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

    @Query(""" 
            SELECT p 
            FROM  Products p 
            WHERE p.active =true AND p.stockQuantity > 0 
            AND LOWER(p.name) 
            LIKE LOWER(CONCAT('%', :keyword, '%'))""")
    List<Products> searchProducts(@Param("keyword") String keyword);


}
