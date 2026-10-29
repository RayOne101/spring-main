package tn.esprit.autoloc.service;

import tn.esprit.autoloc.dto.ReservationDTO;

import java.util.List;

public interface IReservationService {
    ReservationDTO create(ReservationDTO reservation);
    ReservationDTO findById(Long id);
    List<ReservationDTO> findAll();
    ReservationDTO update(Long id, ReservationDTO reservation);
    void deleteById(Long id);
}
