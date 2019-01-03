package org.youssef.com.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youssef.com.entites.Equipement;
import org.youssef.com.entites.preventive;

public interface preventiveRepository  extends JpaRepository<preventive, Long>  {
	
	List<preventive> findByEquipement(Equipement ty);
}
