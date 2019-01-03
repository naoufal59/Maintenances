package org.youssef.com.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class DataPointModel {
	 @Id
     @GeneratedValue
	 private Long id ;
	 private String somaine;
	 private String MTTR;
	 private String MTRF;
	 private String disbo;
	 @ManyToOne
	 @JoinColumn(name="code_equipement")
	 private Equipement equipement;
	 
	 
		public DataPointModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataPointModel(String somaine, String mTTR, String mTRF, String disbo, Equipement equipement) {
		super();
		this.somaine = somaine;
		this.MTTR = mTTR;
		this.MTRF = mTRF;
		this.disbo = disbo;
		this.equipement = equipement;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSomaine() {
		return somaine;
	}
	public void setSomaine(String somaine) {
		this.somaine = somaine;
	}
	public String getMTTR() {
		return MTTR;
	}
	public void setMTTR(String mTTR) {
		MTTR = mTTR;
	}
	public String getMTRF() {
		return MTRF;
	}
	public void setMTRF(String mTRF) {
		MTRF = mTRF;
	}
	public String getDisbo() {
		return disbo;
	}
	public void setDisbo(String disbo) {
		this.disbo = disbo;
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	 
	 
}
