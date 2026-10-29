package tn.esprit.autoloc.service;

import tn.esprit.autoloc.dto.EquipementDTO;

import java.util.List;

public interface IEquipementService {
    EquipementDTO create(EquipementDTO equipement);
    EquipementDTO findById(Long id);
    List<EquipementDTO> findAll();
    EquipementDTO update(Long id, EquipementDTO equipement);
    void deleteById(Long id);
}
