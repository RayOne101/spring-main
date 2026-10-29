package tn.esprit.autoloc.service;

import tn.esprit.autoloc.dto.EmployeDTO;

import java.util.List;

public interface IEmployeService {
    EmployeDTO create(EmployeDTO employe);
    EmployeDTO findById(Long id);
    List<EmployeDTO> findAll();
    EmployeDTO update(Long id, EmployeDTO employe);
    void deleteById(Long id);
}
