package com.batra.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USER_DETAILS database table.
 * 
 */
@Entity
@Table(name="USER_DETAILS")
@NamedQuery(name="UserDetail.findAll", query="SELECT u FROM UserDetail u")
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SEQ_ID")
	private long seqId;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="PASSWORD")
	private String password;

	//@Column(name="\"ROLE\"")
	private String role;

	@Column(name="USERNAME")
	private String username;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="userDetail", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Cart.class)
	private List<Cart> carts;

	//bi-directional many-to-one association to Myorder
	@OneToMany(mappedBy="userDetail" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Myorder.class)
	private List<Myorder> myorders;

	public UserDetail() {
	}

	public long getSeqId() {
		return this.seqId;
	}

	public void setSeqId(long seqId) {
		this.seqId = seqId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setUserDetail(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setUserDetail(null);

		return cart;
	}

	public List<Myorder> getMyorders() {
		return this.myorders;
	}

	public void setMyorders(List<Myorder> myorders) {
		this.myorders = myorders;
	}

	public Myorder addMyorder(Myorder myorder) {
		getMyorders().add(myorder);
		myorder.setUserDetail(this);

		return myorder;
	}

	public Myorder removeMyorder(Myorder myorder) {
		getMyorders().remove(myorder);
		myorder.setUserDetail(null);

		return myorder;
	}

}