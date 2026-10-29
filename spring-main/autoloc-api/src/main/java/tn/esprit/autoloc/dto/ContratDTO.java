package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratDTO {

    private Long idContrat;

    @NotNull(message = "La date de signature est obligatoire")
    private LocalDate dateSignature;

    @NotNull(message = "Le montant total est obligatoire")
    @Min(value = 0, message = "Le montant total ne peut pas etre negatif")
    private BigDecimal montantTotal;

    private boolean valide;

    @NotNull(message = "La reservation du contrat est obligatoire")
    private Long reservationId;
}
