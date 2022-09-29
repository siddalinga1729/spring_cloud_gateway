package com.vaccination_center.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vaccination_center.DTO.Citizen;
import com.vaccination_center.DTO.RequiredResponse;
import com.vaccination_center.entity.VaccinationCenter;
import com.vaccination_center.repo.centerRepo;


@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	@Autowired
	private centerRepo centerRepo;
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter newCitizen) {
		VaccinationCenter saveVaccinationCenter = centerRepo.save(newCitizen);
		return new ResponseEntity<>(saveVaccinationCenter, HttpStatus.OK);
	}
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<RequiredResponse> getById(@PathVariable Integer id) {
		RequiredResponse requiredResponse=new RequiredResponse();
		//1st get vaccinationCentreDetails;
		 VaccinationCenter vaccinationCenter = centerRepo.findById(id).get();
		 requiredResponse.setCenter(vaccinationCenter);
		//then all citizen registerd to vaccination center
		 List<Citizen> listOfCitizens = restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
		 requiredResponse.setCitizens(listOfCitizens);
		 return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
	}
	
}
