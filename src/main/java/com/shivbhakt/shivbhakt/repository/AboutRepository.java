package com.shivbhakt.shivbhakt.repository;

import com.shivbhakt.shivbhakt.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About,Integer> {

}
