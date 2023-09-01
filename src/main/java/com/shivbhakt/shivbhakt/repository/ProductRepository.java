package com.shivbhakt.shivbhakt.repository;

import com.shivbhakt.shivbhakt.entity.Category;
import com.shivbhakt.shivbhakt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByCategory(Category category);
    List<Product> findByTitleContaining(String title);

}
