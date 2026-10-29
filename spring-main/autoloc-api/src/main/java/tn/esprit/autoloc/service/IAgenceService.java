package tn.esprit.autoloc.service;

import tn.esprit.autoloc.dto.AgenceDTO;

import java.util.List;

public interface IAgenceService {
    AgenceDTO create(AgenceDTO agence);
    AgenceDTO findById(Long id);
    List<AgenceDTO> findAll();
    AgenceDTO update(Long id, AgenceDTO agence);
    void deleteById(Long id);
}
