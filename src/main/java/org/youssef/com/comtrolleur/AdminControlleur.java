package org.youssef.com.comtrolleur;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.youssef.com.entites.DataPointModel;
import org.youssef.com.entites.Equipement;
import org.youssef.com.entites.Maintenace;
import org.youssef.com.entites.Solution;
import org.youssef.com.entites.anomalie;
import org.youssef.com.entites.preventive;
import org.youssef.com.metier.CanvasjsChartService;
import org.youssef.com.metier.metierService;

@Controller
@RequestMapping(value ="/admin")
public class AdminControlleur {
	public static Boolean isGotSomthing=false;
	Map<String, Double> canvasjsDataList;
	Map<String, Double> canvasjsDataListMTRF ;
	Map<String, Double> canvasjsDataListdispo ;
	
	public  preventive pr ;
	public  anomalie   anomalie;
	public  Maintenace Maintenace;
	@Autowired
	public metierService metier;
	@Autowired
	private CanvasjsChartService canvasjsChartService;
	private int weekOfYear;

	public int getWeekOfYear() {
		return weekOfYear;
	}
	public void setWeekOfYear(int weekOfYear) {
		this.weekOfYear = weekOfYear;
	}
	
	//Maintenance
	@RequestMapping(value="/index")
	public String home(Model model,@RequestParam(name="code",defaultValue="-1")Long code)
	{  model.addAttribute("Maintenace",new Maintenace());
	 
	   if(code==-1)  model.addAttribute("Maintenaces",metier.listMaintenance());
	   else {
	   Equipement ty = new Equipement();
	   ty.setId(code);
	   model.addAttribute("Maintenaces", metier.findByEquipement(ty));}
	   model.addAttribute("equipemts",metier.findAllEquipement());
	 return "Maintenace";
	}
	@RequestMapping(value="/save" , method =  RequestMethod.POST)
	public String save( Maintenace p,  Model model,@RequestParam(name="code",defaultValue="-1")Long code
			,@RequestParam(name="Etat")Boolean Etat) throws IOException
	{
		  p.setEtat(Etat);
		  metier.ajouterMainteance(p, code);
		  if(p.getEtat().equals(false)) {
			  isGotSomthing=true;
		  }
	    model.addAttribute("Maintenace"  ,new Maintenace());
		model.addAttribute("Maintenaces" ,metier.listMaintenance());
		model.addAttribute("equipemts"   ,metier.findAllEquipement());
		return "redirect:/admin/index";
	}
    @RequestMapping(value="/Valider")
    public String valide(Long id) {
    	metier.validDemande(id);
    	return "redirect:/admin/index";
    }
    @RequestMapping(value="/rejet")
    public String rejet(Long id) {
    	metier.rejectDemande(id);
    	 isGotSomthing=true;
    	return "redirect:/admin/index";
    }
    
    // vedio
	@RequestMapping(value="/Vedio")
	public String Vedio(Model model)
	{   System.out.println(isGotSomthing);
		model.addAttribute("isGotSomthing",isGotSomthing);
	 return "vedio";
	}
	
	//Anomalie
	@RequestMapping(value="/anomalie")
	public String anomalie(Model model,@RequestParam(name="code",defaultValue="-1")Long code)
	{  model.addAttribute("anomalie",new anomalie());
	 
	   if(code==-1)  model.addAttribute("anomalies",metier.listAnomalie());
	   else {
	   Equipement ty = new Equipement();
	   ty.setId(code);
	   model.addAttribute("anomalies", metier.findByEquipementAnomalie(ty));}
	   model.addAttribute("equipemts",metier.findAllEquipement());
	 return "anomalie";
	}
	@RequestMapping(value="saveanomalie" , method =  RequestMethod.POST)
	public String saveanomalie(anomalie p,  Model model,@RequestParam(name="code",defaultValue="-1")Long code
			,@RequestParam(name="typeAnomalie")String Etat) throws IOException
	{
		  p.setTypeAnomalie(Etat);
		  metier.ajouterAnomalie(p, code);
		  isGotSomthing=true;
		  model.addAttribute("anomalie",new anomalie());
		  model.addAttribute("anomalies",metier.listAnomalie());
	      model.addAttribute("equipemts",metier.findAllEquipement());
		return "redirect:/admin/anomalie";
	}
	// Tech
	@RequestMapping(value="/tech")
	public String tech(Model model)
	{   System.out.println(isGotSomthing);
	    model.addAttribute("Maintenace"  ,new Maintenace());
	    model.addAttribute("chasesAnomalie",metier.inValideanomalie());
	    model.addAttribute("preventiveAction", metier.preventiveList());
		model.addAttribute("inValidMaintemnace",metier.inValideMaintenace());
	 return "tech";
	}
	@RequestMapping(value="/solutionMaintenance")
	 public String solutionMaintenance(Long id,Model model) {
		 model.addAttribute("solution", new Solution());
		 Maintenace = metier.getMaintence(id);
	    	return "solutionMa";
	  }
	 @RequestMapping(value="/GotoTheTable")
	 public String GotoTheTable(Solution c) {
	    	metier.GotoTheTable(Maintenace.getIdMaintenace());
	    	c.setMaintenace(Maintenace);
	    	metier.addSolutionMaintenance(c,Maintenace.getIdMaintenace());
	    	return "redirect:/admin/tech";
	  }
	 @RequestMapping(value="/solutionAnomalie")
	 public String solutionAnomalie(Long id,Model model) {
		 model.addAttribute("solution", new Solution());
		 anomalie = metier.getANomalie(id);
	    	return "solutionAn";
	  }
	 @RequestMapping(value="/GotoTheTableAnomalie")
	 public String GotoTheTableAnomalie(Solution c) {
	    	metier.GotoTheTableAnomalie(anomalie.getIdAnomalie());
	    	c.setAnomalie(anomalie);
	    	metier.addSolutionAnomalie(c,anomalie.getIdAnomalie());
	    	return "redirect:/admin/tech";
	  }
	
	 @RequestMapping(value="/solutionPreventivr")
	 public String solutionPreventivr(Long id,Model model) {
		 model.addAttribute("solution", new Solution());
		 pr = metier.getPreventive(id);
	    	return "solution";
	  }
	 @RequestMapping(value="/GotoTheTablepreventivr")
	 public String GotoTheTablepreventivr(Solution c) {
	    	metier.GotoTheTablepreventivr(pr.getIdPreventive());
	    	c.setPreventive(pr);
	    	metier.addSolution(c,pr.getIdPreventive());
	    	return "redirect:/admin/tech";
	  }
	 
	    //preventive main
	    @RequestMapping(value="/preventive")
		public String preventive(Model model,@RequestParam(name="code",defaultValue="-1")Long code)
		{  model.addAttribute("preventive",new preventive());
		 
		   if(code==-1)  model.addAttribute("preventives",metier.listpreventive());
		   else {
		   Equipement ty = new Equipement();
		   ty.setId(code);
		   model.addAttribute("preventives", metier.findByEquipementpreventive(ty));}
		   model.addAttribute("equipemts",metier.findAllEquipement());
		 return "preventive";
		}
	    @RequestMapping(value="/savepreventive" , method =  RequestMethod.POST)
		public String savepreventive( preventive p,  Model model,@RequestParam(name="code",defaultValue="-1")Long code
				,@RequestParam(name="action")String action) throws IOException
		{
	    	 Calendar cal = Calendar.getInstance();
			  p.setAction(action);
			  metier.ajouterpreventive(p, code);
			    int ordinalDay    = cal.get(Calendar.DAY_OF_YEAR);
			    int weekDay       = cal.get(Calendar.DAY_OF_WEEK) - 1; // Sunday = 0
			    int numberOfWeeks = (ordinalDay - weekDay + 10) / 7;
			    System.out.println(numberOfWeeks);
			    System.out.println(p.getNbSomaime());
			if(p.getNbSomaime().equals(""+numberOfWeeks)) {
				  isGotSomthing=true;
			  }
			  model.addAttribute("preventive",new preventive());
		    model.addAttribute("preventives",metier.listpreventive());
			model.addAttribute("equipemts"   ,metier.findAllEquipement());
			return "redirect:/admin/preventive";
		}
	    
	    //Statistiques
	    @RequestMapping(value = "/kpi")
		 public String kpsValue(ModelMap  model,@RequestParam(name="code",defaultValue="-1")Long code) {
	    	 canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
	    	 canvasjsDataListMTRF = canvasjsChartService.getCanvasjsChartDataMTRF();
	         canvasjsDataListdispo = canvasjsChartService.getCanvasjsChartDataDispo();
	         if(code==-1) { 	model.addAttribute("surveyMapdispo", canvasjsDataListdispo);
	         					model.addAttribute("surveyMapMtrf", canvasjsDataListMTRF);
	         					model.addAttribute("surveyMap", canvasjsDataList);}
	         else {
	        	 Equipement ty = new Equipement();
	        	 ty.setId(code);
	        	    model.addAttribute("surveyMapdispo", canvasjsChartService.getCanvasjsChartDataDispoChercher(ty));
					model.addAttribute("surveyMapMtrf", canvasjsChartService.getCanvasjsChartDataMTRFChercher(ty));
					model.addAttribute("surveyMap", canvasjsChartService.getCanvasjsChartDataChercher(ty));
	         }
	    	model.addAttribute("equipemts"   ,metier.findAllEquipement());
	    	model.addAttribute("Kpi", new DataPointModel());
			 return "kpi";
		 }
	    @RequestMapping(value="saveMtr" , method =  RequestMethod.POST)
		public String saveMtr(DataPointModel p,  Model model,@RequestParam(name="code",defaultValue="-1")Long code) throws IOException
		{
			 
			  metier.ajouterMttr(p, code);
			 
			  model.addAttribute("surveyMapdispo", canvasjsDataListdispo);
		    	model.addAttribute("surveyMapMtrf", canvasjsDataListMTRF);
		    	model.addAttribute("surveyMap", canvasjsDataList);
		    	model.addAttribute("equipemts"   ,metier.findAllEquipement());
		    	model.addAttribute("Kpi", new DataPointModel());
			return "redirect:/admin/kpi";
		}
	   }
