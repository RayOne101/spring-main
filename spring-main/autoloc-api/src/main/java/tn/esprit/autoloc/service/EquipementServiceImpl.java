package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.dto.EquipementDTO;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.EquipementMapper;
import tn.esprit.autoloc.repository.IEquipementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipementRepository equipementRepository;
    private final EquipementMapper equipementMapper;

    @Override
    public EquipementDTO create(EquipementDTO equipement) {
        requireNew(equipement.getIdEquipement());
        return equipementMapper.toDto(equipementRepository.save(equipementMapper.toEntity(equipement)));
    }

    @Override
    public EquipementDTO findById(Long id) {
        return equipementMapper.toDto(getEntity(id));
    }

    @Override
    public List<EquipementDTO> findAll() {
        return equipementRepository.findAll().stream()
                .map(equipementMapper::toDto)
                .toList();
    }

    @Override
    public EquipementDTO update(Long id, EquipementDTO equipement) {
        Equipement existing = getEntity(id);
        existing.setLibelle(equipement.getLibelle());
        return equipementMapper.toDto(equipementRepository.save(existing));
    }

    @Override
    public void deleteById(Long id) {
        requireExisting(id);
        equipementRepository.deleteById(id);
    }

    private Equipement getEntity(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement", id));
    }

    private void requireNew(Long id) {
        if (id != null) {
            throw new IllegalArgumentException("Un nouvel equipement ne doit pas avoir d'identifiant");
        }
    }

    private void requireExisting(Long id) {
        if (!equipementRepository.existsById(id)) {
            throw new ResourceNotFoundException("Equipement", id);
        }
    }
}
