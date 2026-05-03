package com.sbu.Ecom.Repository;

import com.sbu.Ecom.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface prodRepo extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Products p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword,'%')) OR "+
            "LOWER(p.description) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%',:keyword,'%'))")
    List<Product> searchProduct(String keyword);

}
