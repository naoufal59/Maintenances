package org.youssef.com.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Solution {

	 @Id
     @GeneratedValue
	 private Long idSolution ;
	 private String description;
	 @ManyToOne
	 @JoinColumn(name="code_anomalie")
	 private anomalie anomalie;
	 @ManyToOne
	 @JoinColumn(name="code_preventive")
	 private preventive preventive;
	 @ManyToOne
	 @JoinColumn(name="code_main")
	 private Maintenace maintenace;
	 
	public Solution(String description, org.youssef.com.entites.anomalie anomalie,
			org.youssef.com.entites.preventive preventive, Maintenace maintenace) {
		super();
		this.description = description;
		this.anomalie = anomalie;
		this.preventive = preventive;
		this.maintenace = maintenace;
	}
	
	public anomalie getAnomalie() {
		return anomalie;
	}

	public void setAnomalie(anomalie anomalie) {
		this.anomalie = anomalie;
	}

	public preventive getPreventive() {
		return preventive;
	}

	public void setPreventive(preventive preventive) {
		this.preventive = preventive;
	}

	public Maintenace getMaintenace() {
		return maintenace;
	}

	public void setMaintenace(Maintenace maintenace) {
		this.maintenace = maintenace;
	}

	public Long getIdSolution() {
		return idSolution;
	}
	public void setIdSolution(Long idSolution) {
		this.idSolution = idSolution;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Solution(String description) {
		super();
		this.description = description;
	}
	public Solution() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
}
