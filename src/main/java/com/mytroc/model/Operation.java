package com.mytroc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Operation")
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String codeUtilEmeteur;
	private String codeUtilRecepteur;
	private float valeurOperation;
	private Date dateOperation;
	private String typeOperation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodeUtilEmeteur() {
		return codeUtilEmeteur;
	}

	public void setCodeUtilEmeteur(String codeUtilEmeteur) {
		this.codeUtilEmeteur = codeUtilEmeteur;
	}

	public String getCodeUtilRecepteur() {
		return codeUtilRecepteur;
	}

	public void setCodeUtilRecepteur(String codeUtilRecepteur) {
		this.codeUtilRecepteur = codeUtilRecepteur;
	}

	public float getValeurOperation() {
		return valeurOperation;
	}

	public void setValeurOperation(float valeurOperation) {
		this.valeurOperation = valeurOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Operation(long id, String codeUtilEmeteur, String codeUtilRecepteur, float valeurOperation,
			Date dateOperation, String typeOperation) {
		super();
		this.id = id;
		this.codeUtilEmeteur = codeUtilEmeteur;
		this.codeUtilRecepteur = codeUtilRecepteur;
		this.valeurOperation = valeurOperation;
		this.dateOperation = dateOperation;
		this.typeOperation = typeOperation;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", codeUtilEmeteur=" + codeUtilEmeteur + ", codeUtilRecepteur="
				+ codeUtilRecepteur + ", valeurOperation=" + valeurOperation + ", dateOperation=" + dateOperation
				+ ", typeOperation=" + typeOperation + "]";
	}

}
