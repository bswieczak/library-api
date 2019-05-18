package com.mgr.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the shippers database table.
 * 
 */
@Entity
@Table(name="shippers")
@NamedQuery(name="Shipper.findAll", query="SELECT s FROM Shipper s")
public class Shipper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer shipperId;

	private String companyName;

	private String phone;

	public Shipper() {
	}

	public Integer getShipperId() {
		return this.shipperId;
	}

	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}