package org.youssef.com.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class anomalie {
 
	 @Id
     @GeneratedValue
	 private Long idAnomalie ;
	 private String description;
	 private String typeAnomalie;
	 private String Referrence;
	 private Boolean etat;
	 private Date dateanomalie;
	 @ManyToOne
	 @JoinColumn(name="code_equipement")
	 private Equipement equipement;
	
	 
	public anomalie(String description, String typeAnomalie, String referrence, Boolean etat, Date dateanomalie,
			Equipement equipement) {
		super();
		this.description = description;
		this.typeAnomalie = typeAnomalie;
		this.Referrence = referrence;
		this.etat = etat;
		this.dateanomalie = dateanomalie;
		this.equipement = equipement;
		
	}

	public Date getDateanomalie() {
		return dateanomalie;
	}

	public void setDateanomalie(Date dateanomalie) {
		this.dateanomalie = dateanomalie;
	}

	public anomalie(String description, String typeAnomalie, String referrence, Equipement equipement,Date date) {
		super();
		this.description  = description;
		this.typeAnomalie = typeAnomalie;
		this.Referrence   = referrence;
		this.equipement   = equipement;
		this.dateanomalie = date;
	}
	
	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public anomalie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdAnomalie() {
		return idAnomalie;
	}
	public void setIdAnomalie(Long idAnomalie) {
		this.idAnomalie = idAnomalie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeAnomalie() {
		return typeAnomalie;
	}
	public void setTypeAnomalie(String typeAnomalie) {
		this.typeAnomalie = typeAnomalie;
	}
	public String getReferrence() {
		return Referrence;
	}
	public void setReferrence(String referrence) {
		Referrence = referrence;
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	 
	 
}
