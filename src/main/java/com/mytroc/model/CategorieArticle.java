package com.mytroc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categorie")
public class CategorieArticle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String codeCategorie;
	private String libelleCategorie;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelleCategorie() {
		return libelleCategorie;
	}

	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}

	public String getCodeCategorie() {
		return codeCategorie;
	}

	public void setCodeCategorie(String codeCategorie) {
		this.codeCategorie = codeCategorie;
	}

	public CategorieArticle(long id, String codeCategorie, String libelleCategorie) {
		super();
		this.id = id;
		this.codeCategorie = codeCategorie;
		this.libelleCategorie = libelleCategorie;
	}

	@Override
	public String toString() {
		return "CategorieArticle [id=" + id + ", codeCategorie=" + codeCategorie + ", libelleCategorie="
				+ libelleCategorie + "]";
	}

	public CategorieArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

}
