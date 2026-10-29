package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.dto.EmployeDTO;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.EmployeMapper;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.repository.IEmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final IEmployeRepository employeRepository;
    private final IAgenceRepository agenceRepository;
    private final EmployeMapper employeMapper;

    @Override
    public EmployeDTO create(EmployeDTO employe) {
        requireNew(employe.getIdEmploye());
        Agence agence = getAgence(employe.getAgenceId());
        return employeMapper.toDto(employeRepository.save(employeMapper.toEntity(employe, agence)));
    }

    @Override
    public EmployeDTO findById(Long id) {
        return employeMapper.toDto(getEntity(id));
    }

    @Override
    public List<EmployeDTO> findAll() {
        return employeRepository.findAll().stream()
                .map(employeMapper::toDto)
                .toList();
    }

    @Override
    public EmployeDTO update(Long id, EmployeDTO employe) {
        Employe existing = getEntity(id);
        existing.setNom(employe.getNom());
        existing.setPrenom(employe.getPrenom());
        existing.setRole(employe.getRole());
        existing.setAgence(getAgence(employe.getAgenceId()));
        return employeMapper.toDto(employeRepository.save(existing));
    }

    @Override
    public void deleteById(Long id) {
        requireExisting(id);
        employeRepository.deleteById(id);
    }

    private Employe getEntity(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employe", id));
    }

    private Agence getAgence(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", id));
    }

    private void requireNew(Long id) {
        if (id != null) {
            throw new IllegalArgumentException("Un nouvel employe ne doit pas avoir d'identifiant");
        }
    }

    private void requireExisting(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employe", id);
        }
    }
}
