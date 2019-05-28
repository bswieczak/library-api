package com.mgr.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Wypozyczenia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_wypozyczenie")
	private Long idWypozyczenie;

	@Temporal(TemporalType.DATE)
	@Column(name="data_oddania")
	private Date dataOddania;

	@Temporal(TemporalType.DATE)
	@Column(name="data_wypozyczenia")
	private Date dataWypozyczenia;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="id_czytelnik")
	private Czytelnicy czytelnicy;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="id_ksiazka")
	private Ksiazki ksiazki;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="id_pracownik_oddanie")
	private Pracownicy pracownikOddanie;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="id_pracownik_wypozyczenie")
	private Pracownicy pracownikWypozyczenie;

	public Wypozyczenia() {
	}


	public Long getIdWypozyczenie() {
		return this.idWypozyczenie;
	}

	public void setIdWypozyczenie(Long idWypozyczenie) {
		this.idWypozyczenie = idWypozyczenie;
	}

	public Date getDataOddania() {
		return this.dataOddania;
	}

	public void setDataOddania(Date dataOddania) {
		this.dataOddania = dataOddania;
	}

	public Date getDataWypozyczenia() {
		return this.dataWypozyczenia;
	}

	public void setDataWypozyczenia(Date dataWypozyczenia) {
		this.dataWypozyczenia = dataWypozyczenia;
	}

	public Czytelnicy getCzytelnicy() {
		return this.czytelnicy;
	}

	public void setCzytelnicy(Czytelnicy czytelnicy) {
		this.czytelnicy = czytelnicy;
	}

	public Ksiazki getKsiazki() {
		return this.ksiazki;
	}

	public void setKsiazki(Ksiazki ksiazki) {
		this.ksiazki = ksiazki;
	}

	public Pracownicy getPracownikOddanie() {
		return this.pracownikOddanie;
	}

	public void setPracownikOddanie(Pracownicy pracownikOddanie) {
		this.pracownikOddanie = pracownikOddanie;
	}

	public Pracownicy getPracownikWypozyczenie() {
		return this.pracownikWypozyczenie;
	}

	public void setPracownikWypozyczenie(Pracownicy pracownikWypozyczenie) {
		this.pracownikWypozyczenie = pracownikWypozyczenie;
	}

}