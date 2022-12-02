package com.batra.api;

import com.batra.model.Order;
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
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@RestController
public class PlaceorderApiController implements PlaceorderApi {

    private static final Logger LOG = LoggerFactory.getLogger(PlaceorderApiController.class);

    @Autowired
    private OrderService orderService;

    /***
     *
     * @param order
     * @return
     */
    public ResponseEntity<OrderResponse> placeorderPost(@Parameter(in = ParameterIn.DEFAULT, description = "body to be saved", required=true, schema=@Schema()) @Valid @RequestBody Order order) {
        LOG.info("Inside Class PlaceorderApiController :: method : placeorderPost");
        OrderResponse orderResponse= orderService.placeorderPost(order);
        return new ResponseEntity<OrderResponse>(orderResponse,HttpStatus.OK);
    }

}
