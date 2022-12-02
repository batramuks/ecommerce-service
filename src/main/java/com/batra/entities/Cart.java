package com.batra.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CART database table.
 * 
 */
@Entity
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CART_ID")
	private long cartId;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="USER_DETAILS_SEQ_ID")
	private UserDetail userDetail;

	//bi-directional many-to-one association to CartItem
	@OneToMany(mappedBy="cart",fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = CartItem.class)
	private List<CartItem> cartItems;

	public Cart() {
	}

	public long getCartId() {
		return this.cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<CartItem> getCartItems() {
		return this.cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public CartItem addCartItem(CartItem cartItem) {
		getCartItems().add(cartItem);
		cartItem.setCart(this);

		return cartItem;
	}

	public CartItem removeCartItem(CartItem cartItem) {
		getCartItems().remove(cartItem);
		cartItem.setCart(null);

		return cartItem;
	}

}