package tn.esprit.autoloc.service;

import tn.esprit.autoloc.dto.MaintenanceDTO;

import java.util.List;

public interface IMaintenanceService {
    MaintenanceDTO create(MaintenanceDTO maintenance);
    MaintenanceDTO findById(Long id);
    List<MaintenanceDTO> findAll();
    MaintenanceDTO update(Long id, MaintenanceDTO maintenance);
    void deleteById(Long id);
}
