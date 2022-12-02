package com.batra.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MYORDER database table.
 * 
 */
@Entity
@NamedQuery(name="Myorder.findAll", query="SELECT m FROM Myorder m")
public class Myorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private long orderId;

	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="SESSION_ID")
	private String sessionId;

	@Column(name="TOTAL_PRICE")
	private BigDecimal totalPrice;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="USER_DETAILS_SEQ_ID")
	private UserDetail userDetail;

	//bi-directional many-to-one association to OrderItem
	@OneToMany(mappedBy="myorder", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = OrderItem.class)
	private List<OrderItem> orderItems;

	public Myorder() {
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public OrderItem addOrderItem(OrderItem orderItem) {
		getOrderItems().add(orderItem);
		orderItem.setMyorder(this);

		return orderItem;
	}

	public OrderItem removeOrderItem(OrderItem orderItem) {
		getOrderItems().remove(orderItem);
		orderItem.setMyorder(null);

		return orderItem;
	}

}