package com.batra.dao;

import com.batra.entities.Cart;
import com.batra.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    /****
     *
     * @param cartId
     * @return
     */

    Cart findByCartId(long cartId);


}