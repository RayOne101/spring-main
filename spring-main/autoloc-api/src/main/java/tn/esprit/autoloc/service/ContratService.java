package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratService implements IContratService {
    private final IContratRepository contratRepository;

    public List<Contrat> retrieveAllContrats() { return contratRepository.findAll(); }
    public Contrat addContrat(Contrat contrat) { return contratRepository.save(contrat); }
    public Contrat updateContrat(Contrat contrat) { return contratRepository.save(contrat); }
    public Contrat retrieveContrat(Long idContrat) {
        return contratRepository.findById(idContrat)
                .orElseThrow(() -> new EntityNotFoundException("Contrat not found: " + idContrat));
    }
    public void removeContrat(Long idContrat) { contratRepository.deleteById(idContrat); }
    public List<Contrat> addContrats(List<Contrat> contrats) { return contratRepository.saveAll(contrats); }
}
