package org.youssef.com.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youssef.com.entites.Equipement;
import org.youssef.com.entites.Maintenace;

public interface maintenaceRepository  extends JpaRepository<Maintenace, Long>  {
	
	List<Maintenace> findByEquipement(Equipement ty);
}
