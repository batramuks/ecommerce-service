package com.batra.service;

import com.batra.dao.OrderRepositoryImpl;
import com.batra.dao.ProductRepository;
import com.batra.dto.RestBaseException;
import com.batra.entities.Myorder;
import com.batra.entities.OrderItem;
import com.batra.entities.Product;
import com.batra.model.Order;
import com.batra.model.OrderListResponse;
import com.batra.model.OrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepositoryImpl orderRepositoryImpl;

    @Autowired
    private ProductRepository productRepository;

    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);

    /****
     *
     * @param order
     * @return
     */
    public OrderResponse placeorderPost(Order order) {
        LOG.info("Inside Class OrderService :: method : placeorderPost");
        OrderResponse orderResponse=orderRepositoryImpl.placeOrder(order);
        return orderResponse;
    }

    /****
     *
     * @param username
     * @return
     */

    public OrderListResponse getOrders(String username) {
        LOG.info("Inside Class OrderService :: method : getOrders");
        OrderListResponse orderListResponse=orderRepositoryImpl.getOrders(username);
        return orderListResponse;
    }

    /****
     *
     * @param orderId
     * @return
     */
    public OrderResponse getOrders(Long orderId) {
        LOG.info("Inside Class OrderService :: method : getOrders");
        OrderResponse orderResponse= new OrderResponse();
        Myorder  order=orderRepositoryImpl.getOrders(orderId);
        if (null==order) {
            throw new RestBaseException(HttpStatus.NOT_FOUND.value(), "Order Not Found");
        }
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
        return orderResponse;
    }
}
