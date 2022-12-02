package com.batra.dao;

import com.batra.dto.RestBaseException;
import com.batra.entities.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartRepositoryImpl {

    private static final Logger LOG = LoggerFactory.getLogger(CartRepositoryImpl.class);

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    /****
     *
     * @param cartRequest
     * @return
     */
    @Transactional
    public long addToCart(com.batra.model.CartRequest cartRequest) {
        LOG.info("Inside Class CartRepositoryImpl :: method : addToCart");

        UserDetail user=userRepository.findByUsername(cartRequest.getUserName());
        if (null==user) {
            throw new RestBaseException(HttpStatus.NOT_FOUND.value(), "User Not Found");
        }
        Cart cartDB= new Cart();
        List<CartItem> cartDBList=new ArrayList<>();
        for (com.batra.model.CartItem  cartItem: cartRequest.getCartItem()){
            CartItem cartDbItem= new CartItem();
            cartDbItem.setProductId(cartItem.getProductId().longValue());
            cartDbItem.setQuantity(cartItem.getQuantity().longValue());
            cartDbItem.setCreatedDate(new Date());
            cartDbItem.setCart(cartDB);
            cartDBList.add(cartDbItem);
        }
        cartDB.setCartItems(cartDBList);
        cartDB.setUserDetail(user);
        Cart cartDbNew=cartRepository.save(cartDB);
        return cartDbNew.getCartId();
    }

}
