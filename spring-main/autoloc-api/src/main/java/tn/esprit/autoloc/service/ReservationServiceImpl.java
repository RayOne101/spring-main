package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.dto.ReservationDTO;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.ReservationMapper;
import tn.esprit.autoloc.repository.IClientRepository;
import tn.esprit.autoloc.repository.IReservationRepository;
import tn.esprit.autoloc.repository.IVehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepository reservationRepository;
    private final IClientRepository clientRepository;
    private final IVehiculeRepository vehiculeRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationDTO create(ReservationDTO reservation) {
        requireNew(reservation.getIdReservation());
        validateDates(reservation);
        return reservationMapper.toDto(reservationRepository.save(
                reservationMapper.toEntity(
                        reservation,
                        getClient(reservation.getClientId()),
                        getVehicule(reservation.getVehiculeId()))));
    }

    @Override
    public ReservationDTO findById(Long id) {
        return reservationMapper.toDto(getEntity(id));
    }

    @Override
    public List<ReservationDTO> findAll() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::toDto)
                .toList();
    }

    @Override
    public ReservationDTO update(Long id, ReservationDTO reservation) {
        Reservation existing = getEntity(id);
        validateDates(reservation);
        existing.setDateDebut(reservation.getDateDebut());
        existing.setDateFin(reservation.getDateFin());
        existing.setStatut(reservation.getStatut());
        existing.setClient(getClient(reservation.getClientId()));
        existing.setVehicule(getVehicule(reservation.getVehiculeId()));
        return reservationMapper.toDto(reservationRepository.save(existing));
    }

    @Override
    public void deleteById(Long id) {
        requireExisting(id);
        reservationRepository.deleteById(id);
    }

    private Reservation getEntity(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", id));
    }

    private Client getClient(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", id));
    }

    private Vehicule getVehicule(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", id));
    }

    private void validateDates(ReservationDTO reservation) {
        if (reservation.getDateDebut() != null && reservation.getDateFin() != null
                && reservation.getDateFin().isBefore(reservation.getDateDebut())) {
            throw new IllegalArgumentException(
                    "La date de fin doit etre posterieure ou egale a la date de debut");
        }
    }

    private void requireNew(Long id) {
        if (id != null) {
            throw new IllegalArgumentException("Une nouvelle reservation ne doit pas avoir d'identifiant");
        }
    }

    private void requireExisting(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reservation", id);
        }
    }
}
