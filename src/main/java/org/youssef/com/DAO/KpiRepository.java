package org.youssef.com.DAO;


import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youssef.com.entites.DataPointModel;
import org.youssef.com.entites.Equipement;

public interface KpiRepository  extends JpaRepository<DataPointModel, Long>  {
	//Map<String,Double> findByEquipement(Equipement ty);
}
