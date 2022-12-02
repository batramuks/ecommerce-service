package com.batra.api;

import com.batra.model.OrderListResponse;
import com.batra.model.OrderResponse;
import com.batra.service.OrderService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class OrdersApiController implements OrdersApi {

    private static final Logger LOG = LoggerFactory.getLogger(OrdersApiController.class);

    @Autowired
    OrderService orderService;

    /***
     *
     * @param username
     * @return
     */
    public ResponseEntity<OrderListResponse> ordersUsernameGet(@PathVariable("username") String username) {
        LOG.info("Inside Class OrdersApiController :: method : ordersUsernameGet");
        OrderListResponse orderListResponse= orderService.getOrders(username);
        return new ResponseEntity<OrderListResponse>(orderListResponse,HttpStatus.OK);
    }

    /***
     *
     * @param orderId
     * @return
     */

    public ResponseEntity<OrderResponse> ordersOrderIdGet(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("orderId") Long orderId) {
        LOG.info("Inside Class OrdersApiController :: method : ordersOrderIdGet");
        OrderResponse orderResponse= orderService.getOrders(orderId);
        return new ResponseEntity<OrderResponse>(orderResponse,HttpStatus.OK);
    }


}
