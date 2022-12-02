package com.batra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Product
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-25T17:14:59.355Z[GMT]")


public class Product   {
  @JsonProperty("productId")
  private String productId = null;

  @JsonProperty("productName")
  private String productName = null;

  @JsonProperty("productPrice")
  private Double productPrice = null;

  public Product productId(String productId) {
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

  public Product productName(String productName) {
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

  public Product productPrice(Double productPrice) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.productId, product.productId) &&
        Objects.equals(this.productName, product.productName) &&
        Objects.equals(this.productPrice, product.productPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, productName, productPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
