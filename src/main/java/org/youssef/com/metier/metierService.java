package org.youssef.com.metier;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.youssef.com.DAO.EquipementRepository;
import org.youssef.com.DAO.KpiRepository;
import org.youssef.com.DAO.SolutionRepository;
import org.youssef.com.DAO.anomalieRepository;
import org.youssef.com.DAO.maintenaceRepository;
import org.youssef.com.DAO.preventiveRepository;
import org.youssef.com.comtrolleur.AdminControlleur;
import org.youssef.com.entites.DataPointModel;
import org.youssef.com.entites.Equipement;
import org.youssef.com.entites.Maintenace;
import org.youssef.com.entites.Solution;
import org.youssef.com.entites.anomalie;
import org.youssef.com.entites.preventive;

@Service
public class metierService {
		@Autowired
		public KpiRepository kpiRepository;
		@Autowired
		public SolutionRepository solutionRepository;
	  @Autowired
	  public maintenaceRepository maintenaceRepository;
	  @Autowired
	  public EquipementRepository equipementRepository;
	  @Autowired
	  public anomalieRepository anomalieRepository;
	  @Autowired
	  public preventiveRepository preventiveRepository;
	    @Transactional
	    public List<Maintenace> listMaintenance()  {
	    	return maintenaceRepository.findAll();
	    }
	    @Transactional
	    public List<preventive> listpreventive()  {
	    	return preventiveRepository.findAll();
	    }
	    @Transactional
	    public List<anomalie> listAnomalie()  {
	    	return anomalieRepository.findAll();
	    }
	    @Transactional
	    public List<Equipement> findAllEquipement()  {
	    	return equipementRepository.findAll();
	    }
	    @Transactional
	    public Maintenace ajouterMainteance(Maintenace c, Long IdEquipemnet)  {
	    	Equipement eq = equipementRepository.getOne(IdEquipemnet);
	    	c.setEquipement(eq);
	    	c.setDatemaintenace(new Date());
	    	return maintenaceRepository.save(c);
	    }
	    @Transactional
	    public preventive ajouterpreventive(preventive c, Long IdEquipemnet)  {
	    	Equipement eq = equipementRepository.getOne(IdEquipemnet);
	    	c.setEquipement(eq);
	    	c.setEtat(false);
	    	c.setDate(new Date());
	    	return preventiveRepository.save(c);
	    }
	    
	    /*@Transactional
		public List<preventive> inValidepreventive() {
			List<preventive> preventives =preventiveRepository.findAll();
			List<preventive> preventive = new ArrayList<>();
			for (preventive maintenac : preventives) {
				if(maintenac.getEtat().equals(false)) {
					preventive.add(maintenac);
				}
			}
			return preventive;
		}*/
	    
	    
	    @Transactional
	    public anomalie ajouterAnomalie(anomalie c, Long IdEquipemnet)  {
	    	Equipement eq = equipementRepository.getOne(IdEquipemnet);
	    	c.setEquipement(eq);
	    	Random rng = new Random(); 
	    	int next = rng.nextInt(100) + 1;
	        c.setReferrence(""+next);
	        c.setEtat(false);
	        c.setDateanomalie(new Date());
	    	return anomalieRepository.save(c);
	    }
	    @Transactional
	    public Equipement getEquipement(Long idC)  {
	   	 	return equipementRepository.getOne(idC);
	    }
	    @Transactional
	    public List<Maintenace> findByEquipement(Equipement ty)  {
	    	return maintenaceRepository.findByEquipement(ty);
	    }
	    @Transactional
	    public List<preventive> findByEquipementpreventive(Equipement ty)  {
	    	return preventiveRepository.findByEquipement(ty);
	    }
	    @Transactional
	    public List<anomalie> findByEquipementAnomalie(Equipement ty)  {
	    	return anomalieRepository.findByEquipement(ty);
	    }
	    @Transactional
		public void validDemande(Long demandeID) {
			this.maintenaceRepository.getOne(demandeID).setEtat(true);
			
		}
		@Transactional
		public void rejectDemande(Long demandeID) {
			this.maintenaceRepository.getOne(demandeID).setEtat(false);
		}
		@Transactional
		public List<Maintenace> inValideMaintenace() {
			List<Maintenace> maintenaces =maintenaceRepository.findAll();
			List<Maintenace> maintenace = new ArrayList<>();
			for (Maintenace maintenac : maintenaces) {
				if(maintenac.getEtat().equals(false)) {
					maintenace.add(maintenac);
				}
			}
			return maintenace;
		}
		@Transactional
		public void GotoTheTable(Long id) {
			AdminControlleur.isGotSomthing=false;
			this.maintenaceRepository.getOne(id).setEtat(true);
			
		}
		    @Transactional
		    public Solution addSolution(Solution c, Long IdPreventive)  {
		    	preventive eq = preventiveRepository.getOne(IdPreventive);
		    	c.setPreventive(eq);
		    	return solutionRepository.save(c);
		    }
		    @Transactional
		    public Solution addSolutionAnomalie(Solution c, Long IdPreventive)  {
		    	anomalie eq = anomalieRepository.getOne(IdPreventive);
		    	c.setAnomalie(eq);
		    	return solutionRepository.save(c);
		    }
		    @Transactional
		    public Solution addSolutionMaintenance(Solution c, Long IdPreventive)  {
		    	Maintenace eq = maintenaceRepository.getOne(IdPreventive);
		    	c.setMaintenace(eq);
		    	return solutionRepository.save(c);
		    }
		@Transactional
		public preventive getPreventive(Long id) {
		
			return this.preventiveRepository.getOne(id);
			
		}
		@Transactional
		public anomalie getANomalie(Long id) {
		
			return this.anomalieRepository.getOne(id);
			
		}
		@Transactional
		public Maintenace getMaintence(Long id) {
		
			return this.maintenaceRepository.getOne(id);
			
		}
		@Transactional
		public void GotoTheTablepreventivr(Long id) {
			AdminControlleur.isGotSomthing=false;
			this.preventiveRepository.getOne(id).setEtat(true);
			
		}
		@Transactional
		public void GotoTheTableAnomalie(Long id) {
			AdminControlleur.isGotSomthing=false;
			this.anomalieRepository.getOne(id).setEtat(true);
			
		}
		@Transactional
		public List<anomalie> inValideanomalie() {
			List<anomalie> anomalies =anomalieRepository.findAll();
			List<anomalie> anomalie = new ArrayList<>();
			for (anomalie main : anomalies) {
				if(main.getEtat().equals(false)) {
					anomalie.add(main);
				}
			}
			return anomalie;
		}
		@Transactional
		public List<preventive> preventiveList() {
			List<preventive> anomalies =preventiveRepository.findAll();
			List<preventive> anomalie = new ArrayList<>();
		     	Calendar cal      = Calendar.getInstance();
			    int ordinalDay    = cal.get(Calendar.DAY_OF_YEAR);
			    int weekDay       = cal.get(Calendar.DAY_OF_WEEK) - 1; // Sunday = 0
			    int numberOfWeeks = (ordinalDay - weekDay + 10) / 7;
			for (preventive main : anomalies) {
				if(main.getNbSomaime().equals(""+numberOfWeeks) && main.getEtat().equals(false) ) {
					anomalie.add(main);
				}
			}
			return anomalie;
		}
		@Transactional
		public DataPointModel ajouterMttr(DataPointModel p, Long code) {
			Equipement eq = equipementRepository.getOne(code);
	    	p.setEquipement(eq);
	    
			return  kpiRepository.save(p);
			
		}
		
		
		@Transactional
		public static void writeObjectToCSV(PrintWriter writer,List<Maintenace> maintenaces) {
			try (
					CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
		                    .withHeader("Description", "Comment", "Pilot", "Equipement","date"));
			) {
				for (Maintenace customer : maintenaces) {
					List<? extends Object> data = Arrays.asList(
							customer.getDescription(),
							customer.getComment(),
							customer.getPilot(),
							customer.getEquipement().getNom(),
							customer.getDatemaintenace()
						);
					
					csvPrinter.printRecord(data);
				}
				csvPrinter.flush();
			} catch (Exception e) {
				System.out.println("Writing CSV error!");
				e.printStackTrace();
			}
		}
		
		@Transactional
		public static void writeAnomalieObjectToCSV(PrintWriter writer,List<anomalie> anomalies) {
			try (
					CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
		                    .withHeader("Description", "Ref", "Type", "Equipement","date"));
			) {
				for (anomalie customer : anomalies) {
					List<? extends Object> data = Arrays.asList(
							customer.getDescription(),
							customer.getReferrence(),
							customer.getTypeAnomalie(),
							customer.getEquipement().getNom(),
							customer.getDateanomalie()
						);
					
					csvPrinter.printRecord(data);
				}
				csvPrinter.flush();
			} catch (Exception e) {
				System.out.println("Writing CSV error!");
				e.printStackTrace();
			}
		}
		@Transactional
		public static void writepreventiveObjectToCSV(PrintWriter writer,List<preventive> preventives) {
			try (
					CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
		                    .withHeader("la somaine", "Etat", "Action", "Equipement","date"));
			) {
				for (preventive customer : preventives) {
					List<? extends Object> data = Arrays.asList(
							customer.getNbSomaime(),
							customer.getEtat(),
							customer.getAction(),
							customer.getEquipement().getNom(),
							customer.getDate()
						);
					
					csvPrinter.printRecord(data);
				}
				csvPrinter.flush();
			} catch (Exception e) {
				System.out.println("Writing CSV error!");
				e.printStackTrace();
			}
		}
}
