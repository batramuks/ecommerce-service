package com.batra.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ORDER_ITEMS database table.
 * 
 */
@Entity
@Table(name="ORDER_ITEMS")
@NamedQuery(name="OrderItem.findAll", query="SELECT o FROM OrderItem o")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ITEM_ID")
	private long orderItemId;

	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="PRICE")
	private BigDecimal price;

	@Column(name="PRODUCT_ID")
	private Long productId;

	@Column(name="QUANTITY")
	private Long quantity;

	//bi-directional many-to-one association to Myorder
	@ManyToOne
	@JoinColumn(name="MYORDER_ORDER_ID")
	private Myorder myorder;

	public OrderItem() {
	}

	public long getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Myorder getMyorder() {
		return this.myorder;
	}

	public void setMyorder(Myorder myorder) {
		this.myorder = myorder;
	}

}