package com.mgr.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_rola")
	private Integer idRola;

	private String nazwa;

	public Role() {
	}

	public Integer getIdRola() {
		return this.idRola;
	}

	public void setIdRola(Integer idRola) {
		this.idRola = idRola;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}