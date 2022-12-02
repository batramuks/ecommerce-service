package com.batra.dao;

import com.batra.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class ProductRepositoryImpl {

    private static final Logger LOG = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    @Autowired
    private ProductRepository productRepository;

    /****
     *
     * @param product
     */
    @Transactional
    public void createProduct(Product product) {
        LOG.info("Inside Class ProductRepositoryImpl :: method : createProduct");
        com.batra.entities.Product productDao = new com.batra.entities.Product();
        productDao.setName(product.getProductName());
        productDao.setPrice(BigDecimal.valueOf(product.getProductPrice()));
            try{
         productRepository.save(productDao);
            } catch (DataAccessException e) {
            LOG.error("Error during save application object", e);
        }
    }

    /****
     *
     * @return
     */
    public List<com.batra.entities.Product> getProducts() {
        LOG.info("Inside Class ProductRepositoryImpl :: method : getProducts");
        List<com.batra.entities.Product> productList= productRepository.findAll();
        return productList;

    }
}
