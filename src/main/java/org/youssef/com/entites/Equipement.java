package org.youssef.com.entites;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Equipement {

	@Id
    @GeneratedValue
	 private Long id;
	 private String description;
	 private String nom;
	 private Boolean etat;
	 /*@OneToMany(mappedBy="equipement")
	 private Collection<Kpi> kpis;*/
	public Equipement(String description, String nom, Boolean etat) {
		super();
		this.description = description;
		this.nom = nom;
		this.etat = etat;
	}
	public Equipement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	 
}
