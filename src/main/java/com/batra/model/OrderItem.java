package com.batra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-01T22:36:30.014Z[GMT]")


public class OrderItem   {
  @JsonProperty("productId")
  private String productId = null;

  @JsonProperty("productName")
  private String productName = null;

  @JsonProperty("productPrice")
  private Double productPrice = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  public OrderItem productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * The Identifier of the Customers Application
   * @return productId
   **/
  @Schema(description = "The Identifier of the Customers Application")
  
    public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public OrderItem productName(String productName) {
    this.productName = productName;
    return this;
  }

  /**
   * Product Category
   * @return productName
   **/
  @Schema(description = "Product Category")
  
    public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public OrderItem productPrice(Double productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  /**
   * Get productPrice
   * @return productPrice
   **/
  @Schema(description = "")
  
    public Double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Double productPrice) {
    this.productPrice = productPrice;
  }

  public OrderItem quantity(Integer quantity) {
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
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(this.productId, orderItem.productId) &&
        Objects.equals(this.productName, orderItem.productName) &&
        Objects.equals(this.productPrice, orderItem.productPrice) &&
        Objects.equals(this.quantity, orderItem.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, productName, productPrice, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
