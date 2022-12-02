package com.batra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CartRequest
 */



public class CartRequest   {
  @JsonProperty("cartItem")
  @Valid
  private List<CartItem> cartItem = null;

  @JsonProperty("userName")
  private String userName = null;

  public CartRequest cartItem(List<CartItem> cartItem) {
    this.cartItem = cartItem;
    return this;
  }

  public CartRequest addCartItemItem(CartItem cartItemItem) {
    if (this.cartItem == null) {
      this.cartItem = new ArrayList<CartItem>();
    }
    this.cartItem.add(cartItemItem);
    return this;
  }

  /**
   * Get cartItem
   * @return cartItem
   **/
  @Schema(description = "")
      @Valid
    public List<CartItem> getCartItem() {
    return cartItem;
  }

  public void setCartItem(List<CartItem> cartItem) {
    this.cartItem = cartItem;
  }

  public CartRequest userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
   **/
  @Schema(description = "")
  
    public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartRequest cartRequest = (CartRequest) o;
    return Objects.equals(this.cartItem, cartRequest.cartItem) &&
        Objects.equals(this.userName, cartRequest.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cartItem, userName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartRequest {\n");
    
    sb.append("    cartItem: ").append(toIndentedString(cartItem)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
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
