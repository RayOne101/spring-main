package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.dto.MaintenanceDTO;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.MaintenanceMapper;
import tn.esprit.autoloc.repository.IMaintenanceRepository;
import tn.esprit.autoloc.repository.IVehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;
    private final IVehiculeRepository vehiculeRepository;
    private final MaintenanceMapper maintenanceMapper;

    @Override
    public MaintenanceDTO create(MaintenanceDTO maintenance) {
        requireNew(maintenance.getIdMaintenance());
        validateDates(maintenance);
        return maintenanceMapper.toDto(maintenanceRepository.save(
                maintenanceMapper.toEntity(maintenance, getVehicule(maintenance.getVehiculeId()))));
    }

    @Override
    public MaintenanceDTO findById(Long id) {
        return maintenanceMapper.toDto(getEntity(id));
    }

    @Override
    public List<MaintenanceDTO> findAll() {
        return maintenanceRepository.findAll().stream()
                .map(maintenanceMapper::toDto)
                .toList();
    }

    @Override
    public MaintenanceDTO update(Long id, MaintenanceDTO maintenance) {
        Maintenance existing = getEntity(id);
        validateDates(maintenance);
        existing.setDateDebut(maintenance.getDateDebut());
        existing.setDateFin(maintenance.getDateFin());
        existing.setDescription(maintenance.getDescription());
        existing.setVehicule(getVehicule(maintenance.getVehiculeId()));
        return maintenanceMapper.toDto(maintenanceRepository.save(existing));
    }

    @Override
    public void deleteById(Long id) {
        requireExisting(id);
        maintenanceRepository.deleteById(id);
    }

    private Maintenance getEntity(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance", id));
    }

    private Vehicule getVehicule(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", id));
    }

    private void validateDates(MaintenanceDTO maintenance) {
        if (maintenance.getDateDebut() != null && maintenance.getDateFin() != null
                && maintenance.getDateFin().isBefore(maintenance.getDateDebut())) {
            throw new IllegalArgumentException(
                    "La date de fin doit etre posterieure ou egale a la date de debut");
        }
    }

    private void requireNew(Long id) {
        if (id != null) {
            throw new IllegalArgumentException("Une nouvelle maintenance ne doit pas avoir d'identifiant");
        }
    }

    private void requireExisting(Long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Maintenance", id);
        }
    }
}
