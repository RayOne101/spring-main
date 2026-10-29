package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.dto.EmployeDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeMapper {

    @Mapping(target = "agenceId", source = "agence.idAgence")
    EmployeDTO toDto(Employe employe);

    @Mapping(target = "agence", ignore = true)
    Employe toEntity(EmployeDTO dto);

    default Employe toEntity(EmployeDTO dto, Agence agence) {
        Employe employe = toEntity(dto);
        employe.setAgence(agence);
        return employe;
    }
}
