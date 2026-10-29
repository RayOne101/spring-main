package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.dto.VehiculeDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehiculeMapper {

    @Mapping(target = "agenceId", source = "agence.idAgence")
    VehiculeDTO toDto(Vehicule vehicule);

    @Mapping(target = "agence", ignore = true)
    Vehicule toEntity(VehiculeDTO dto);

    default Vehicule toEntity(VehiculeDTO dto, Agence agence) {
        Vehicule vehicule = toEntity(dto);
        vehicule.setAgence(agence);
        return vehicule;
    }
}
