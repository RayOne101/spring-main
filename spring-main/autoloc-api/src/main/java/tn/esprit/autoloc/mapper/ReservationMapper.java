package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.dto.ReservationDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    @Mapping(target = "clientId", source = "client.idClient")
    @Mapping(target = "vehiculeId", source = "vehicule.idVehicule")
    ReservationDTO toDto(Reservation reservation);

    @Mapping(target = "client", ignore = true)
    @Mapping(target = "vehicule", ignore = true)
    Reservation toEntity(ReservationDTO dto);

    default Reservation toEntity(ReservationDTO dto, Client client, Vehicule vehicule) {
        Reservation reservation = toEntity(dto);
        reservation.setClient(client);
        reservation.setVehicule(vehicule);
        return reservation;
    }
}
