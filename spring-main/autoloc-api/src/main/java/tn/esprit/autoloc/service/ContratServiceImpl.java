package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.repository.IContratRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final IContratRepository contratRepository;

    @Override
    public Contrat create(Contrat contrat) {
        requireNew(contrat.getIdContrat());
        validate(contrat);
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat findById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat", id));
    }

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat update(Long id, Contrat contrat) {
        Contrat existing = findById(id);
        validate(contrat);
        existing.setDateSignature(contrat.getDateSignature());
        existing.setMontantTotal(contrat.getMontantTotal());
        existing.setValide(contrat.isValide());
        existing.setReservation(contrat.getReservation());
        return contratRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        requireExisting(id);
        contratRepository.deleteById(id);
    }

    private void validate(Contrat contrat) {
        BigDecimal amount = contrat.getMontantTotal();
        if (amount != null && amount.signum() < 0) {
            throw new IllegalArgumentException("Le montant total du contrat ne peut pas être négatif");
        }
    }

    private void requireNew(Long id) {
        if (id != null) {
            throw new IllegalArgumentException("Un nouveau contrat ne doit pas avoir d'identifiant");
        }
    }

    private void requireExisting(Long id) {
        if (!contratRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contrat", id);
        }
    }
}
