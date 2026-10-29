package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.dto.MaintenanceDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MaintenanceMapper {

    @Mapping(target = "vehiculeId", source = "vehicule.idVehicule")
    MaintenanceDTO toDto(Maintenance maintenance);

    @Mapping(target = "vehicule", ignore = true)
    Maintenance toEntity(MaintenanceDTO dto);

    default Maintenance toEntity(MaintenanceDTO dto, Vehicule vehicule) {
        Maintenance maintenance = toEntity(dto);
        maintenance.setVehicule(vehicule);
        return maintenance;
    }
}
