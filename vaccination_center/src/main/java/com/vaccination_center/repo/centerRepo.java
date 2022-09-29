package com.vaccination_center.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaccination_center.DTO.Citizen;
import com.vaccination_center.entity.VaccinationCenter;

public interface centerRepo extends JpaRepository<VaccinationCenter, Integer> {

	//List<VaccinationCenter> findByVaccinationCenterId(Integer id);



}
