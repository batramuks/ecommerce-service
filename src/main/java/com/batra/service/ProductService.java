package com.batra.service;

import com.batra.dto.RestBaseException;
import com.batra.model.Product;
import com.batra.dao.ProductRepositoryImpl;
import com.batra.model.ProductListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepositoryImpl productRepositoryImpl;

    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    /***
     *
     * @param product
     */
    public void createProduct(Product product) {
        LOG.info("Inside Class ProductService :: method : createProduct");
        productRepositoryImpl.createProduct(product);

    }
    /***
     *
     * @return
     */
    public ProductListResponse  getProducts() {
        LOG.info("Inside Class ProductService :: method : getProducts");
        ProductListResponse productListResponse= new ProductListResponse();
        List<com.batra.entities.Product> productList= productRepositoryImpl.getProducts();
        if (CollectionUtils.isEmpty(productList)) {
            throw new RestBaseException(HttpStatus.NOT_FOUND.value(), "Data Not Found");
        }
        List<Product> productRespList= new ArrayList<>();
        for( com.batra.entities.Product productDB: productList) {
            Product productResponse= new Product();
            productResponse.setProductId(productDB.getProductId().toString());
            productResponse.setProductPrice(productDB.getPrice().doubleValue());
            productResponse.setProductName(productDB.getName());
            productRespList.add(productResponse);
        }

        productListResponse.setProducts(productRespList);
        return productListResponse;
    }
}
