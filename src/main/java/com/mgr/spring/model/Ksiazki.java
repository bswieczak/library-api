package com.mgr.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQuery(name="Ksiazki.findAll", query="SELECT k FROM Ksiazki k")
public class Ksiazki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_ksiazka")
	private Integer idKsiazka;

	private String isbn;

	private String opis;

	@Column(name="rok_wydania")
	private Integer rokWydania;

	private String tytul;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="id_autor")
	private Autorzy autorzy;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="id_kategoria")
	private Kategorie kategorie;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="id_wydawnictwo")
	private Wydawnictwa wydawnictwa;

	public Ksiazki() {
	}

	public Integer getIdKsiazka() {
		return this.idKsiazka;
	}

	public void setIdKsiazka(Integer idKsiazka) {
		this.idKsiazka = idKsiazka;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Integer getRokWydania() {
		return this.rokWydania;
	}

	public void setRokWydania(Integer rokWydania) {
		this.rokWydania = rokWydania;
	}

	public String getTytul() {
		return this.tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public Autorzy getAutorzy() {
		return this.autorzy;
	}

	public void setAutorzy(Autorzy autorzy) {
		this.autorzy = autorzy;
	}

	public Kategorie getKategorie() {
		return this.kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public Wydawnictwa getWydawnictwa() {
		return this.wydawnictwa;
	}

	public void setWydawnictwa(Wydawnictwa wydawnictwa) {
		this.wydawnictwa = wydawnictwa;
	}

}