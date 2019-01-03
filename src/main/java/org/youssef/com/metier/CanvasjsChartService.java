package org.youssef.com.metier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.youssef.com.DAO.KpiRepository;
import org.youssef.com.entites.DataPointModel;
import org.youssef.com.entites.Equipement;


@Service
public class CanvasjsChartService {

	@Autowired
	public KpiRepository kpiRepository;
	@Transactional
	public Map<String, Double> getCanvasjsChartData() {
		
		Map<String, Double> map = new LinkedHashMap<String, Double>();
	    
		
		List<DataPointModel> resultSet = kpiRepository.findAll();
		
		for (DataPointModel kpi : resultSet) {
			map.put( kpi.getSomaine(), Double.parseDouble(kpi.getMTTR())); 
			//System.out.println(map);
		}
	
    	return map;
	}
	@Transactional
	public Map<String, Double> getCanvasjsChartDataChercher(Equipement ty) {
		
		Map<String, Double> map = new LinkedHashMap<String, Double>();
	    
		
		List<DataPointModel> resultSet = kpiRepository.findAll();
		
		for (DataPointModel kpi : resultSet) {
			if(kpi.getEquipement().getId().equals(ty.getId())) {
			map.put( kpi.getSomaine(), Double.parseDouble(kpi.getMTTR())); 
			}
		}
	
    	return map;
	}
	@Transactional
	public Map<String, Double> getCanvasjsChartDataMTRF() {
		
		Map<String, Double> map = new LinkedHashMap<String, Double>();
		List<DataPointModel> resultSet = kpiRepository.findAll();
		
		for (DataPointModel kpi : resultSet) {
			map.put( kpi.getSomaine(), Double.parseDouble(kpi.getMTRF())); 
			
		}
	
    	return map;
	}
	@Transactional
	public Map<String, Double> getCanvasjsChartDataMTRFChercher(Equipement ty) {
		
		Map<String, Double> map = new LinkedHashMap<String, Double>();
		List<DataPointModel> resultSet = kpiRepository.findAll();
		
		for (DataPointModel kpi : resultSet) {
			if(kpi.getEquipement().getId().equals(ty.getId())) {
			map.put( kpi.getSomaine(), Double.parseDouble(kpi.getMTRF())); 
			}
		}
	
    	return map;
	}
	@Transactional
	public Map<String, Double> getCanvasjsChartDataDispo() {
		
		Map<String, Double> map = new LinkedHashMap<String, Double>();
		List<DataPointModel> resultSet = kpiRepository.findAll();
		
		for (DataPointModel kpi : resultSet) {
			map.put( kpi.getSomaine(), Double.parseDouble(kpi.getDisbo())); 
			
		}
	
    	return map;
	}
	@Transactional
	public Map<String, Double> getCanvasjsChartDataDispoChercher(Equipement ty) {
		
		Map<String, Double> map = new LinkedHashMap<String, Double>();
		List<DataPointModel> resultSet = kpiRepository.findAll();
		
		for (DataPointModel kpi : resultSet) {
			if(kpi.getEquipement().getId().equals(ty.getId())) {
			map.put( kpi.getSomaine(), Double.parseDouble(kpi.getDisbo())); 
			}
		}
	
    	return map;
	}
}
