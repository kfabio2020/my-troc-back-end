package com.mytroc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pret")
public class Pret {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String codeArticle;
	private String codeUtilPret;
	private Date datePret;
	private Date dateRetour;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getCodeUtilPret() {
		return codeUtilPret;
	}

	public void setCodeUtilPret(String codeUtilPret) {
		this.codeUtilPret = codeUtilPret;
	}

	public Date getDatePret() {
		return datePret;
	}

	public void setDatePret(Date datePret) {
		this.datePret = datePret;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Pret(long id, String codeArticle, String codeUtilPret, Date datePret, Date dateRetour) {
		super();
		this.id = id;
		this.codeArticle = codeArticle;
		this.codeUtilPret = codeUtilPret;
		this.datePret = datePret;
		this.dateRetour = dateRetour;
	}

	@Override
	public String toString() {
		return "Pret [id=" + id + ", codeArticle=" + codeArticle + ", codeUtilPret=" + codeUtilPret + ", datePret="
				+ datePret + ", dateRetour=" + dateRetour + "]";
	}

}
