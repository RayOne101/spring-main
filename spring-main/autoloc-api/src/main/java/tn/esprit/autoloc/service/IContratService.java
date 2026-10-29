package tn.esprit.autoloc.service;

import tn.esprit.autoloc.dto.ContratDTO;

import java.util.List;

public interface IContratService {
    ContratDTO create(ContratDTO contrat);
    ContratDTO findById(Long id);
    List<ContratDTO> findAll();
    ContratDTO update(Long id, ContratDTO contrat);
    void deleteById(Long id);
}
