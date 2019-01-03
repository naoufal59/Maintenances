package org.youssef.com.comtrolleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.youssef.com.entites.Maintenace;
import org.youssef.com.entites.anomalie;
import org.youssef.com.entites.preventive;
import org.youssef.com.metier.metierService;

@Controller
@RequestMapping(value ="/admin")
public class ExcelControlleur {
	@Autowired
	public metierService metier;
	  
	    @GetMapping(value="/CSVmaintenance/Maintenance.csv" )
		public void downloadCSV(HttpServletResponse response) throws IOException{
			response.setContentType("text/csv");
			response.setHeader("Content-Disposition", "attachment; file=Maintenance.csv");
			
			List<Maintenace> customers = metier.inValideMaintenace(); 
			metierService.writeObjectToCSV(response.getWriter(), customers);
		}
	    
	    @GetMapping(value="/CSVanomalie/anomalie.csv" )
		public void downloadCSVanomalie(HttpServletResponse response) throws IOException{
			response.setContentType("text/csv");
			response.setHeader("Content-Disposition", "attachment; file=anomalie.csv");
			
			List<anomalie> customers = metier.inValideanomalie(); 
			metierService.writeAnomalieObjectToCSV(response.getWriter(), customers);
		}
	    @GetMapping(value="/CSVpreventive/prevetive.csv" )
		public void downloadCSVpreventive(HttpServletResponse response) throws IOException{
			response.setContentType("text/csv");
			response.setHeader("Content-Disposition", "attachment; file=anomalie.csv");
			
			List<preventive> customers = metier.preventiveList(); 
			metierService.writepreventiveObjectToCSV(response.getWriter(), customers);
		}

}
