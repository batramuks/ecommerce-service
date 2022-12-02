package com.batra.model;

import java.util.Date;
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
 * OrderResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-01T22:36:30.014Z[GMT]")


public class OrderResponse   {
  @JsonProperty("username")
  private String username = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("orderId")
  private Long orderId = null;

  @JsonProperty("orderItem")
  @Valid
  private List<OrderItem> orderItem = null;

  @JsonProperty("totalPrice")
  private Double totalPrice = null;

  @JsonProperty("createdDate")
  private Date createdDate = null;

  public OrderResponse username(String username) {
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

  public OrderResponse email(String email) {
    this.email = email;
    return this;
  }


  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }


  /**
   * username
   * @return email
   **/
  @Schema(description = "username")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public OrderResponse orderItem(List<OrderItem> orderItem) {
    this.orderItem = orderItem;
    return this;
  }

  public OrderResponse addOrderItemItem(OrderItem orderItemItem) {
    if (this.orderItem == null) {
      this.orderItem = new ArrayList<OrderItem>();
    }
    this.orderItem.add(orderItemItem);
    return this;
  }

  /**
   * Get orderItem
   * @return orderItem
   **/
  @Schema(description = "")
      @Valid
    public List<OrderItem> getOrderItem() {
    return orderItem;
  }

  public void setOrderItem(List<OrderItem> orderItem) {
    this.orderItem = orderItem;
  }

  public OrderResponse totalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

  /**
   * totalPrice
   * @return totalPrice
   **/
  @Schema(description = "totalPrice")
  
    public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderResponse orderResponse = (OrderResponse) o;
    return Objects.equals(this.username, orderResponse.username) &&
        Objects.equals(this.email, orderResponse.email) &&
        Objects.equals(this.orderItem, orderResponse.orderItem) &&
        Objects.equals(this.totalPrice, orderResponse.totalPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, email, orderItem, totalPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderResponse {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    orderItem: ").append(toIndentedString(orderItem)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
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
