package com.mytroc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String codeArticle;
	private String codeCategorie;
	private String codeUtil;
	private String libelleArticle;
	private float pointArticle;
	private String photo;
	private Date dateCreation;
	private String etatArticle;

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

	public String getCodeCategorie() {
		return codeCategorie;
	}

	public void setCodeCategorie(String codeCategorie) {
		this.codeCategorie = codeCategorie;
	}

	public String getLibelleArticle() {
		return libelleArticle;
	}

	public void setLibelleArticle(String libelleArticle) {
		this.libelleArticle = libelleArticle;
	}

	public float getPointArticle() {
		return pointArticle;
	}

	public void setPointArticle(float pointArticle) {
		this.pointArticle = pointArticle;
	}

	public String getCodeUtil() {
		return codeUtil;
	}

	public void setCodeUtil(String codeUtil) {
		this.codeUtil = codeUtil;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getEtatArticle() {
		return etatArticle;
	}

	public void setEtatArticle(String etatArticle) {
		this.etatArticle = etatArticle;
	}

	public Article(long id, String codeArticle, String codeCategorie, String codeUtil, String libelleArticle,
			float pointArticle, String photo, Date dateCreation, String etatArticle) {
		super();
		this.id = id;
		this.codeArticle = codeArticle;
		this.codeCategorie = codeCategorie;
		this.codeUtil = codeUtil;
		this.libelleArticle = libelleArticle;
		this.pointArticle = pointArticle;
		this.photo = photo;
		this.dateCreation = dateCreation;
		this.etatArticle = etatArticle;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", codeArticle=" + codeArticle + ", codeCategorie=" + codeCategorie + ", codeUtil="
				+ codeUtil + ", libelleArticle=" + libelleArticle + ", pointArticle=" + pointArticle + ", photo="
				+ photo + ", dateCreation=" + dateCreation + ", etatArticle=" + etatArticle + "]";
	}

}
