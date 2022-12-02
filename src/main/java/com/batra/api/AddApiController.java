package com.batra.api;

import com.batra.model.CartRequest;
import com.batra.service.CartService;
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
public class AddApiController implements AddApi {

    private static final Logger LOG = LoggerFactory.getLogger(AddApiController.class);
    @Autowired
    private CartService cartService;

    @Override
    public ResponseEntity<Long> addPost(@Parameter(in = ParameterIn.DEFAULT, description = "body to be saved", required=true, schema=@Schema()) @Valid @RequestBody CartRequest cartRequest) {
        LOG.info("Inside Class AddApiController :: method : addPost");
        Long cartId=cartService.addToCart(cartRequest);
        return new ResponseEntity<Long>(cartId,HttpStatus.OK);
    }


}
