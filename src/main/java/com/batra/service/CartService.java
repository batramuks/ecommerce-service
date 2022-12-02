package com.batra.service;

import com.batra.dao.CartRepositoryImpl;
import com.batra.model.CartRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepositoryImpl cartrepositoryImpl;

    private static final Logger LOG = LoggerFactory.getLogger(CartService.class);

    public Long addToCart(CartRequest cartRequest) {
        LOG.info("Inside Class CartService :: method : addToCart");
        long cartId = cartrepositoryImpl.addToCart(cartRequest);
        return cartId;

    }
}
