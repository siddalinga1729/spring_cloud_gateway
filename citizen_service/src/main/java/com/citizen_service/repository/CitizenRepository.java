package com.citizen_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citizen_service.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
public List<Citizen> findByVaccinationCenterId(Integer id);
}
