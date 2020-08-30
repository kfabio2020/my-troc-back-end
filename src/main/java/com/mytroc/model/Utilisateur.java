package com.mytroc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String codeUtil;
	private String nomUtil;
	private String prenomUtil;
	private String email;
	private String telephone;
	private String adresse;
	private String login;
	private String motPass;
	private Date dateCreation;
	private String etatCompte;
	private float soldePoint;

	public String getCodeUtil() {
		return codeUtil;
	}

	public void setCodeUtil(String codeUtil) {
		this.codeUtil = codeUtil;
	}

	public String getNomUtil() {
		return nomUtil;
	}

	public void setNomUtil(String nomUtil) {
		this.nomUtil = nomUtil;
	}

	public String getPrenomUtil() {
		return prenomUtil;
	}

	public void setPrenomUtil(String prenomUtil) {
		this.prenomUtil = prenomUtil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotPass() {
		return motPass;
	}

	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getEtatCompte() {
		return etatCompte;
	}

	public void setEtatCompte(String etatCompte) {
		this.etatCompte = etatCompte;
	}

	public float getSoldePoint() {
		return soldePoint;
	}

	public void setSoldePoint(float soldePoint) {
		this.soldePoint = soldePoint;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utilisateur(long id, String codeUtil, String nomUtil, String prenomUtil, String email, String telephone,
			String adresse, String login, String motPass, Date dateCreation, String etatCompte, float soldePoint) {
		super();
		this.id = id;
		this.codeUtil = codeUtil;
		this.nomUtil = nomUtil;
		this.prenomUtil = prenomUtil;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.login = login;
		this.motPass = motPass;
		this.dateCreation = dateCreation;
		this.etatCompte = etatCompte;
		this.soldePoint = soldePoint;
	}

	public Utilisateur() {
		super();
	}
	
}
