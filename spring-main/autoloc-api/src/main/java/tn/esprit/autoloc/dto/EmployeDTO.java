package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.autoloc.domain.RoleEmploye;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDTO {

    private Long idEmploye;

    @NotBlank(message = "Le nom de l'employe est obligatoire")
    @Size(max = 50, message = "Le nom ne doit pas depasser 50 caracteres")
    private String nom;

    @NotBlank(message = "Le prenom de l'employe est obligatoire")
    @Size(max = 50, message = "Le prenom ne doit pas depasser 50 caracteres")
    private String prenom;

    @NotNull(message = "Le role de l'employe est obligatoire")
    private RoleEmploye role;

    @NotNull(message = "L'agence de l'employe est obligatoire")
    private Long agenceId;
}
