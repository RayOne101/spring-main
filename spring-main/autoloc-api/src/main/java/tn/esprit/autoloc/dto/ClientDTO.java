package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long idClient;

    @NotBlank(message = "Le nom du client est obligatoire")
    @Size(max = 50, message = "Le nom ne doit pas depasser 50 caracteres")
    private String nom;

    @NotBlank(message = "Le prenom du client est obligatoire")
    @Size(max = 50, message = "Le prenom ne doit pas depasser 50 caracteres")
    private String prenom;

    @NotBlank(message = "L'email du client est obligatoire")
    @Email(message = "L'email du client doit etre valide")
    @Size(max = 100, message = "L'email ne doit pas depasser 100 caracteres")
    private String email;

    @NotBlank(message = "Le telephone du client est obligatoire")
    @Size(max = 20, message = "Le telephone ne doit pas depasser 20 caracteres")
    private String telephone;

    @NotBlank(message = "Le numero de permis est obligatoire")
    @Size(max = 20, message = "Le numero de permis ne doit pas depasser 20 caracteres")
    private String numPermis;

    @NotNull(message = "La date d'inscription est obligatoire")
    private LocalDate dateInscription;
}
