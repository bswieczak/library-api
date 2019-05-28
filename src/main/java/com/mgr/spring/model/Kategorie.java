package com.mgr.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Kategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_kategoria")
	private Integer idKategoria;

	private String nazwa;

	public Kategorie() {
	}

	public Integer getIdKategoria() {
		return this.idKategoria;
	}

	public void setIdKategoria(Integer idKategoria) {
		this.idKategoria = idKategoria;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}