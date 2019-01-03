package org.youssef.com.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.youssef.com.entites.Equipement;
import org.youssef.com.entites.Solution;

public interface SolutionRepository  extends JpaRepository<Solution, Long>  {

}
