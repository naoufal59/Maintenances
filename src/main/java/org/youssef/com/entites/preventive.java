package org.youssef.com.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class preventive {

	 @Id
     @GeneratedValue
	 private Long idPreventive ;
	 private String nbSomaime;
	 private String action;
	 private Boolean etat;
	 private Date date;
	 @ManyToOne
	 @JoinColumn(name="code_equipement")
	 private Equipement equipement;
	
	 
	public preventive(String nbSomaime, String action, Boolean etat, Date date, Equipement equipement
			) {
		super();
		this.nbSomaime = nbSomaime;
		this.action = action;
		this.etat = etat;
		this.date = date;
		this.equipement = equipement;
		
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public preventive() {
		super();
		// TODO Auto-generated constructor stub
	}
	public preventive(String nbSomaime, String action, Equipement equipement,Date date ) {
		super();
		this.nbSomaime  = nbSomaime;
		this.action     = action;
		this.equipement = equipement;
		this.date       = date;
	}
	
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public Long getIdPreventive() {
		return idPreventive;
	}
	public void setIdPreventive(Long idPreventive) {
		this.idPreventive = idPreventive;
	}
	public String getNbSomaime() {
		return nbSomaime;
	}
	public void setNbSomaime(String nbSomaime) {
		this.nbSomaime = nbSomaime;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	 
	 
}
