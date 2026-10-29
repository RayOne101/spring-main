package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.autoloc.domain.StatutReservation;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Long idReservation;

    @NotNull(message = "La date de debut est obligatoire")
    private LocalDate dateDebut;

    @NotNull(message = "La date de fin est obligatoire")
    private LocalDate dateFin;

    @NotNull(message = "Le statut de la reservation est obligatoire")
    private StatutReservation statut;

    @NotNull(message = "Le client de la reservation est obligatoire")
    private Long clientId;

    @NotNull(message = "Le vehicule de la reservation est obligatoire")
    private Long vehiculeId;
}
