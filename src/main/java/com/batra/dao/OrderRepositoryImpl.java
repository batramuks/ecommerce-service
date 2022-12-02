package com.batra.dao;

import com.batra.dto.RestBaseException;
import com.batra.entities.*;
import com.batra.model.Order;
import com.batra.model.OrderListResponse;
import com.batra.model.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class OrderRepositoryImpl {

    private static final Logger LOG = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Autowired
    private ProductRepository productRepository;

    /****
     *
     * @param order
     * @return
     */
    @Transactional
    public OrderResponse placeOrder(Order order) {
        LOG.info("Inside Class OrderRepositoryImpl :: method : placeOrder");
        OrderResponse orderResponse= new OrderResponse();
        long cartId =order.getCartId();
        Cart cart=cartRepository.findByCartId(cartId);
        if (null==cart) {
            throw new RestBaseException(HttpStatus.NOT_FOUND.value(), "Cart Not Found");
        }
         UserDetail user=userRepository.findByUsername(order.getUsername());
        // create the order and save it
        com.batra.entities.Myorder newOrder = new com.batra.entities.Myorder();
        newOrder.setCreatedDate(new Date());
        newOrder.setUserDetail(cart.getUserDetail());
        List<OrderItem> orderItemsDbList=new ArrayList<>();
        double total=0;
        for (CartItem cartItemDb : cart.getCartItems()) {
            // create orderItem and save each one
            OrderItem orderItem = new OrderItem();
            orderItem.setCreatedDate(new Date());
            Product product=productRepository.getByProductId(cartItemDb.getProductId());
            orderItem.setPrice(product.getPrice());
            orderItem.setProductId(cartItemDb.getProductId());
            orderItem.setQuantity(cartItemDb.getQuantity());
            orderItem.setMyorder(newOrder);
            total= (total + (cartItemDb.getQuantity() * product.getPrice().doubleValue()));
            orderItemsDbList.add(orderItem);
        }
        newOrder.setTotalPrice(BigDecimal.valueOf(total));
        newOrder.setOrderItems(orderItemsDbList);

        Myorder savedOrder =orderRepository.save(newOrder);
        setOrderResponse(orderResponse, newOrder);
        cartRepository.deleteById(cartId);

    return orderResponse;
    }

    /****
     *
     * @param orderResponse
     * @param savedOrder
     */
    private void setOrderResponse(OrderResponse orderResponse, Myorder savedOrder) {
        orderResponse.setOrderId(savedOrder.getOrderId());
        orderResponse.setUsername(savedOrder.getUserDetail().getUsername());
        orderResponse.setCreatedDate(savedOrder.getCreatedDate());
        orderResponse.setEmail(savedOrder.getUserDetail().getEmail());
        orderResponse.setTotalPrice(savedOrder.getTotalPrice().doubleValue());

    }

    /****
     *
     * @param username
     * @return
     */
    @Transactional
    public com.batra.entities.Myorder getCarts(String username) {
        LOG.info("Inside Class OrderRepositoryImpl :: method : getCarts");
        UserDetail user=userRepository.findByUsername(username);
        for (com.batra.entities.Cart cartDb: user.getCarts()){
              List<CartItem>  cartItems=cartDb.getCartItems();
                for (com.batra.entities.CartItem cartItem : cartItems) {
                    cartItem.getCartItemId();
                    cartItem.getProductId();
                    Product product = productRepository.getByProductId(cartItem.getProductId());
                    product.getName();
                    product.getPrice();
                    cartItem.getQuantity();
                    cartItem.getCreatedDate();
                }
            cartDb.getCartId();
                }

        return null;
    }

    /****
     *
     * @param username
     * @return
     */
    @Transactional
    public OrderListResponse  getOrders(String username) {
    LOG.info("Inside Class OrderRepositoryImpl :: method : getOrders");
        UserDetail user=userRepository.findByUsername(username);
        if (null==user) {
            throw new RestBaseException(HttpStatus.NOT_FOUND.value(), "User Not Found");
        }
        List<com.batra.entities.Myorder> orderList=user.getMyorders();
        OrderListResponse orderListResponse= new OrderListResponse();
        List<OrderResponse> orderResList= new ArrayList<>();
       for (com.batra.entities.Myorder order: orderList){
            OrderResponse orderResponse= new OrderResponse();
            orderResponse.setUsername(order.getUserDetail().getUsername());
            orderResponse.setEmail(order.getUserDetail().getEmail());
            orderResponse.setTotalPrice(order.getTotalPrice().doubleValue());
            orderResponse.setOrderId(order.getOrderId());
            orderResponse.setCreatedDate(order.getCreatedDate());
            List<OrderItem> orderDBList=order.getOrderItems();
            List<com.batra.model.OrderItem> orderItemRespList= new ArrayList<>();
            for (OrderItem orderDBItem: orderDBList){
                com.batra.model.OrderItem OrderItemResp= new com.batra.model.OrderItem();
                OrderItemResp.setProductId(orderDBItem.getProductId().toString());
                OrderItemResp.setQuantity(orderDBItem.getQuantity().intValue());
                OrderItemResp.setProductPrice(orderDBItem.getPrice().doubleValue());
                Product product = productRepository.getByProductId(orderDBItem.getProductId());
                OrderItemResp.setProductName(product.getName());
                orderItemRespList.add(OrderItemResp);
            }
            orderResponse.setOrderItem(orderItemRespList);

        orderResList.add(orderResponse)  ;
        }
      orderListResponse.setOrderResponse(orderResList);
        return orderListResponse;
    }

    /****
     *
     * @param orderId
     * @return
     */

    @Transactional
    public com.batra.entities.Myorder  getOrders(Long orderId) {
        LOG.info("Inside Class OrderRepositoryImpl :: method : getOrders");
        com.batra.entities.Myorder order=orderRepository.findByOrderId(orderId);
        return order;
    }
}
