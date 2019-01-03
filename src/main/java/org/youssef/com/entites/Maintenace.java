package org.youssef.com.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Maintenace {
	 @Id
     @GeneratedValue
	 private Long idMaintenace ;
	 private String description;
	 private String comment;
	 private String pilot;
	 private Boolean Etat;
	 private Date datemaintenace;
	 @ManyToOne
	 @JoinColumn(name="code_equipement")
	 private Equipement equipement;
	 
	public Date getDatemaintenace() {
		return datemaintenace;
	}
	public void setDatemaintenace(Date datemaintenace) {
		this.datemaintenace = datemaintenace;
	}
	public Maintenace() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Maintenace(String description, String comment, String pilot, Boolean etat, Date datemaintenace,
			Equipement equipement) {
		super();
		this.description = description;
		this.comment = comment;
		this.pilot = pilot;
		Etat = etat;
		this.datemaintenace = datemaintenace;
		this.equipement = equipement;
		
	}
	public Maintenace(String description, String comment, String pilot, Boolean etat, Equipement equipement,Date date) {
		super();
		this.description = description;
		this.comment = comment;
		this.pilot = pilot;
		this.Etat = etat;
		this.equipement = equipement;
		this.datemaintenace=date;
	}
	public Long getIdMaintenace() {
		return idMaintenace;
	}
	public void setIdMaintenace(Long idMaintenace) {
		this.idMaintenace = idMaintenace;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPilot() {
		return pilot;
	}
	public void setPilot(String pilot) {
		this.pilot = pilot;
	}
	public Boolean getEtat() {
		return Etat;
	}
	public void setEtat(Boolean etat) {
		Etat = etat;
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	 
	 
	 
}
