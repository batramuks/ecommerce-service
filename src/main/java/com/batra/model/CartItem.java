package com.batra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CartItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-26T18:33:43.483Z[GMT]")


public class CartItem   {
  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("quantity")
  private Integer quantity = null;



  public CartItem productId(Integer productId) {
    this.productId = productId;
    return this;
  }

  /**
   * The Identifier of the Customers Application
   * @return productId
   **/
  @Schema(description = "The Identifier of the Customers Application")
  
    public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public CartItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Product Category
   * @return quantity
   **/
  @Schema(description = "Product Category")
  
    public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartItem cartItem = (CartItem) o;
    return Objects.equals(this.productId, cartItem.productId) &&
        Objects.equals(this.quantity, cartItem.quantity) ;
  }





}
