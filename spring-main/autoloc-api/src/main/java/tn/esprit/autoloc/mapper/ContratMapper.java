package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.dto.ContratDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContratMapper {

    @Mapping(target = "reservationId", source = "reservation.idReservation")
    ContratDTO toDto(Contrat contrat);

    @Mapping(target = "reservation", ignore = true)
    Contrat toEntity(ContratDTO dto);

    default Contrat toEntity(ContratDTO dto, Reservation reservation) {
        Contrat contrat = toEntity(dto);
        contrat.setReservation(reservation);
        return contrat;
    }
}
