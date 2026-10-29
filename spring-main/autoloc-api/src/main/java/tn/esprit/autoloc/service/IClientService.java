package tn.esprit.autoloc.service;

import tn.esprit.autoloc.dto.ClientDTO;

import java.util.List;

public interface IClientService {
    ClientDTO create(ClientDTO client);
    ClientDTO findById(Long id);
    List<ClientDTO> findAll();
    ClientDTO update(Long id, ClientDTO client);
    void deleteById(Long id);
}
