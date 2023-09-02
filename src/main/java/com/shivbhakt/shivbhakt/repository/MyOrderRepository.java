package com.shivbhakt.shivbhakt.repository;

import com.shivbhakt.shivbhakt.entity.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyOrderRepository extends JpaRepository<MyOrder,Integer> {
}
