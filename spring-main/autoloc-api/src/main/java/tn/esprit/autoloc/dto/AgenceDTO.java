package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgenceDTO {

    private Long idAgence;

    @NotBlank(message = "Le nom de l'agence est obligatoire")
    @Size(max = 100, message = "Le nom de l'agence ne doit pas depasser 100 caracteres")
    private String nom;

    @NotBlank(message = "La ville de l'agence est obligatoire")
    @Size(max = 100, message = "La ville ne doit pas depasser 100 caracteres")
    private String ville;

    @NotBlank(message = "L'adresse de l'agence est obligatoire")
    @Size(max = 255, message = "L'adresse ne doit pas depasser 255 caracteres")
    private String adresse;

    @NotBlank(message = "Le telephone de l'agence est obligatoire")
    @Size(max = 20, message = "Le telephone ne doit pas depasser 20 caracteres")
    private String telephone;
}
