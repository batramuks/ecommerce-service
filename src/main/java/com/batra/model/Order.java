package com.batra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-27T10:52:49.951Z[GMT]")


public class Order   {
  @JsonProperty("username")
  private String username = null;

  @JsonProperty("cartId")
  private Integer cartId = null;

  public Order username(String username) {
    this.username = username;
    return this;
  }

  /**
   * username
   * @return username
   **/
  @Schema(description = "username")
  
    public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Order cartId(Integer cartId) {
    this.cartId = cartId;
    return this;
  }

  /**
   * cartId
   * @return cartId
   **/
  @Schema(description = "cartId")
  
    public Integer getCartId() {
    return cartId;
  }

  public void setCartId(Integer cartId) {
    this.cartId = cartId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.username, order.username) &&
        Objects.equals(this.cartId, order.cartId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, cartId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
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
