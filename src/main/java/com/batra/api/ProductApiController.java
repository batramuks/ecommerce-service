package com.batra.api;

import com.batra.model.Product;
import com.batra.model.ProductListResponse;
import com.batra.service.ProductService;
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
public class ProductApiController implements ProductApi {

    @Autowired
    private ProductService productService;

    private static final Logger LOG = LoggerFactory.getLogger(ProductApiController.class);
    /****
     *
     * @param product
     * @return
     */
    public ResponseEntity<Void> productPost(@Parameter(in = ParameterIn.DEFAULT, description = "body to be saved", required=true, schema=@Schema()) @Valid @RequestBody Product product) {
        LOG.info("Inside Class ProductApiController :: method : productPost");
        productService.createProduct(product);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    /****
     *
     * @return
     */

    public ResponseEntity<ProductListResponse> productsGet() {
        LOG.info("Inside Class ProductApiController :: method : productsGet");
        ProductListResponse productListResponse = productService.getProducts();
        return new ResponseEntity<ProductListResponse>(productListResponse,HttpStatus.OK);
    }


}
