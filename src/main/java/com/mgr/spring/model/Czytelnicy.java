package com.mgr.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Czytelnicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_czytelnik")
	private Integer idCzytelnik;

	@Temporal(TemporalType.DATE)
	@Column(name="data_urodzenia")
	private Date dataUrodzenia;

	private String email;

	private String haslo;

	private String login;

	private String telefon;

	public Czytelnicy() {
	}

	public Integer getIdCzytelnik() {
		return this.idCzytelnik;
	}

	public void setIdCzytelnik(Integer idCzytelnik) {
		this.idCzytelnik = idCzytelnik;
	}

	public Date getDataUrodzenia() {
		return this.dataUrodzenia;
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}