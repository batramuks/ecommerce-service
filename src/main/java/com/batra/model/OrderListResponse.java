package com.batra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderListResponse
 */


public class OrderListResponse   {
  @JsonProperty("orderResponse")
  @Valid
  private List<OrderResponse> orderResponse = null;

  public OrderListResponse orderResponse(List<OrderResponse> orderResponse) {
    this.orderResponse = orderResponse;
    return this;
  }

  public OrderListResponse addOrderResponseItem(OrderResponse orderResponseItem) {
    if (this.orderResponse == null) {
      this.orderResponse = new ArrayList<OrderResponse>();
    }
    this.orderResponse.add(orderResponseItem);
    return this;
  }

  /**
   * Get orderResponse
   * @return orderResponse
   **/
  @Schema(description = "")
      @Valid
    public List<OrderResponse> getOrderResponse() {
    return orderResponse;
  }

  public void setOrderResponse(List<OrderResponse> orderResponse) {
    this.orderResponse = orderResponse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderListResponse orderListResponse = (OrderListResponse) o;
    return Objects.equals(this.orderResponse, orderListResponse.orderResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderListResponse {\n");
    
    sb.append("    orderResponse: ").append(toIndentedString(orderResponse)).append("\n");
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
