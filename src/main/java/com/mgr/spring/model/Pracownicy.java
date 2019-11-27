package com.mgr.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Pracownicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pracownik")
	private Integer idPracownik;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="id_rola")
	private Role role;

	public Pracownicy() {
	}

	public Integer getIdPracownik() {
		return this.idPracownik;
	}

	public void setIdPracownik(Integer idPracownik) {
		this.idPracownik = idPracownik;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}