package com.vaccination_center.DTO;

import java.util.List;

import com.vaccination_center.entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {
 private VaccinationCenter center;
 private List<Citizen> citizens;
}
 