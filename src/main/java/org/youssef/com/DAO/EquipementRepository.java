package org.youssef.com.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.youssef.com.entites.Equipement;

public interface EquipementRepository  extends JpaRepository<Equipement, Long>  {

}
