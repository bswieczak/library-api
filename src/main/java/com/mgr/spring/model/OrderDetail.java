package com.mgr.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order_details database table.
 *
 */
@Entity
@Table(name="order_details")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailPK id;

	private float discount;

	private Integer quantity;

	private float unitPrice;

	@MapsId("orderId")
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
	private Order order;

	@MapsId("productId")
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public OrderDetail() {
	}

	public OrderDetailPK getId() {
		return id;
	}

	public void setId(OrderDetailPK id) {
		this.id = id;
	}

	public float getDiscount() {
		return this.discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}