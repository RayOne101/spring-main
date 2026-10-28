package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.repository.IReservationRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    private final IReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {
        requireNew(reservation.getIdReservation());
        validate(reservation);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", id));
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        Reservation existing = findById(id);
        validate(reservation);
        existing.setDateDebut(reservation.getDateDebut());
        existing.setDateFin(reservation.getDateFin());
        existing.setStatut(reservation.getStatut());
        existing.setVehicule(reservation.getVehicule());
        existing.setClient(reservation.getClient());
        return reservationRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        requireExisting(id);
        reservationRepository.deleteById(id);
    }

    private void validate(Reservation reservation) {
        if (reservation.getDateDebut() != null && reservation.getDateFin() != null
                && reservation.getDateFin().isBefore(reservation.getDateDebut())) {
            throw new IllegalArgumentException("La date de fin doit être postérieure ou égale à la date de début");
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
