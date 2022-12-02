package com.batra.dao;

import com.batra.entities.Myorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Myorder, Long> {
   /***
    *
    * @param orderId
    * @return
    */
   Myorder findByOrderId(Long orderId);


   }