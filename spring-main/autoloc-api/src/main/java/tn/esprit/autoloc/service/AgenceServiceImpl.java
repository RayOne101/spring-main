package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.dto.AgenceDTO;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.AgenceMapper;
import tn.esprit.autoloc.repository.IAgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;
    private final AgenceMapper agenceMapper;

    @Override
    public AgenceDTO create(AgenceDTO agence) {
        requireNew(agence.getIdAgence());
        return agenceMapper.toDto(agenceRepository.save(agenceMapper.toEntity(agence)));
    }

    @Override
    public AgenceDTO findById(Long id) {
        return agenceMapper.toDto(getEntity(id));
    }

    @Override
    public List<AgenceDTO> findAll() {
        return agenceRepository.findAll().stream()
                .map(agenceMapper::toDto)
                .toList();
    }

    @Override
    public AgenceDTO update(Long id, AgenceDTO agence) {
        Agence existing = getEntity(id);
        existing.setNom(agence.getNom());
        existing.setVille(agence.getVille());
        existing.setAdresse(agence.getAdresse());
        existing.setTelephone(agence.getTelephone());
        return agenceMapper.toDto(agenceRepository.save(existing));
    }

    @Override
    public void deleteById(Long id) {
        requireExisting(id);
        agenceRepository.deleteById(id);
    }

    private Agence getEntity(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", id));
    }

    private void requireNew(Long id) {
        if (id != null) {
            throw new IllegalArgumentException("Une nouvelle agence ne doit pas avoir d'identifiant");
        }
    }

    private void requireExisting(Long id) {
        if (!agenceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Agence", id);
        }
    }
}
