package com.mgr.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Wydawnictwa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_wydawnictwo")
	private Integer idWydawnictwo;

	private String nazwa;

	public Wydawnictwa() {
	}

	public Integer getIdWydawnictwo() {
		return this.idWydawnictwo;
	}

	public void setIdWydawnictwo(Integer idWydawnictwo) {
		this.idWydawnictwo = idWydawnictwo;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}