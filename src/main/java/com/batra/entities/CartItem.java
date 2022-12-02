package com.batra.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CART_ITEM database table.
 * 
 */
@Entity
@Table(name="CART_ITEM")
@NamedQuery(name="CartItem.findAll", query="SELECT c FROM CartItem c")
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CART_ITEM_ID")
	private long cartItemId;

	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="PRODUCT_ID")
	private Long productId;

	@Column(name="QUANTITY")
	private Long quantity;

	//bi-directional many-to-one association to Cart
	@ManyToOne
	@JoinColumn(name="CART_CART_ID")
	private Cart cart;

	public CartItem() {
	}

	public long getCartItemId() {
		return this.cartItemId;
	}

	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}