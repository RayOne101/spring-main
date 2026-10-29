package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.dto.AgenceDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AgenceMapper {

    AgenceDTO toDto(Agence agence);

    Agence toEntity(AgenceDTO dto);
}
