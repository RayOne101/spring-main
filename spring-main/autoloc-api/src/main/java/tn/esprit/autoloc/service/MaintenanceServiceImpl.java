package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.repository.IMaintenanceRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {
    private final IMaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance create(Maintenance maintenance) {
        requireNew(maintenance.getIdMaintenance());
        validate(maintenance);
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance findById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance", id));
    }

    @Override
    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance update(Long id, Maintenance maintenance) {
        Maintenance existing = findById(id);
        validate(maintenance);
        existing.setDateDebut(maintenance.getDateDebut());
        existing.setDateFin(maintenance.getDateFin());
        existing.setDescription(maintenance.getDescription());
        existing.setVehicule(maintenance.getVehicule());
        return maintenanceRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        requireExisting(id);
        maintenanceRepository.deleteById(id);
    }

    private void validate(Maintenance maintenance) {
        if (maintenance.getDateDebut() != null && maintenance.getDateFin() != null
                && maintenance.getDateFin().isBefore(maintenance.getDateDebut())) {
            throw new IllegalArgumentException("La date de fin doit être postérieure ou égale à la date de début");
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
