package com.shivbhakt.shivbhakt.repository;

import com.shivbhakt.shivbhakt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
