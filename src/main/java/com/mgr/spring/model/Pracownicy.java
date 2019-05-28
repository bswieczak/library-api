package com.mgr.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQuery(name="Pracownicy.findAll", query="SELECT p FROM Pracownicy p")
public class Pracownicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pracownik")
	private Integer idPracownik;

	private String haslo;

	private String login;

	@ManyToOne
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

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}