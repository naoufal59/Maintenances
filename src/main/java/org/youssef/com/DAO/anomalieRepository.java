package org.youssef.com.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youssef.com.entites.Equipement;
import org.youssef.com.entites.Maintenace;
import org.youssef.com.entites.anomalie;

public interface anomalieRepository  extends JpaRepository<anomalie, Long>  {
	
	List<anomalie> findByEquipement(Equipement ty);
}
