package com.shivbhakt.shivbhakt.repository;

import com.shivbhakt.shivbhakt.entity.Comment;
import com.shivbhakt.shivbhakt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findByProduct(Product product);
}
