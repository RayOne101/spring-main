package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.dto.EquipementDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EquipementMapper {

    EquipementDTO toDto(Equipement equipement);

    Equipement toEntity(EquipementDTO dto);
}
