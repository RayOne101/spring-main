package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeDTO {

    private Long idVehicule;

    @NotBlank(message = "L'immatriculation est obligatoire")
    @Size(max = 20, message = "L'immatriculation ne doit pas depasser 20 caracteres")
    private String immatriculation;

    @NotBlank(message = "La marque est obligatoire")
    @Size(max = 50, message = "La marque ne doit pas depasser 50 caracteres")
    private String marque;

    @NotBlank(message = "Le modele est obligatoire")
    @Size(max = 50, message = "Le modele ne doit pas depasser 50 caracteres")
    private String modele;

    @NotNull(message = "La categorie est obligatoire")
    private CategorieVehicule categorie;

    @NotNull(message = "Le tarif journalier est obligatoire")
    @Min(value = 0, message = "Le tarif journalier ne peut pas etre negatif")
    private BigDecimal tarifJournalier;

    @NotNull(message = "Le statut est obligatoire")
    private StatutVehicule statut;

    @NotNull(message = "L'agence du vehicule est obligatoire")
    private Long agenceId;
}
