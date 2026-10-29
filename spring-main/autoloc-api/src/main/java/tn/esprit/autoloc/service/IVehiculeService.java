package tn.esprit.autoloc.service;

import tn.esprit.autoloc.dto.VehiculeDTO;

import java.util.List;

public interface IVehiculeService {
    VehiculeDTO create(VehiculeDTO vehicule);
    VehiculeDTO findById(Long id);
    List<VehiculeDTO> findAll();
    VehiculeDTO update(Long id, VehiculeDTO vehicule);
    void deleteById(Long id);
}
