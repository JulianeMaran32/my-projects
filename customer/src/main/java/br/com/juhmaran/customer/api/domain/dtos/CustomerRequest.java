package br.com.juhmaran.customer.api.domain.dtos;

import br.com.juhmaran.customer.core.util.CpfUtil;
import br.com.juhmaran.customer.core.validation.annotations.NotEmptyNotNullNotBlank;
import br.com.juhmaran.customer.core.validation.annotations.ValidCpf;
import br.com.juhmaran.customer.core.validation.annotations.ValidPhone;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CustomerRequest", description = "Objeto de requisição para cadastro de cliente")
public class CustomerRequest {

    @Schema(name = "fullName", description = "Nome completo do cliente",
            minLength = 3, maxLength = 150, requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 3, max = 150, message = "The fullName field must be between {min} and {max} characters.")
    @NotEmptyNotNullNotBlank(message = "The fullName field cannot be empty, null, or blank.")
    private String fullName;

    @Schema(name = "email", description = "E-mail do cliente", format = "email",
            minLength = 3, maxLength = 150, requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 3, max = 150, message = "The email field must be between {min} and {max} characters.")
    @NotEmptyNotNullNotBlank(message = "The email field cannot be empty, null, or blank.")
    @Email(message = "Please provide a valid email address.")
    private String email;

    @Schema(name = "documentNumber", description = "Número de documento do cliente (CPF)", format = "cpf",
            minLength = 11, maxLength = 14, requiredMode = Schema.RequiredMode.REQUIRED)
    @ValidCpf(message = "Invalid document number. Please provide a valid CPF with or without a mask.")
    @CPF(message = "Please provide a valid CPF number.")
    private String documentNumber;

    @Schema(name = "phoneNumber", description = "Número de telefone do cliente", format = "phone",
            minLength = 10, maxLength = 15, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmptyNotNullNotBlank(message = "The phoneNumber field cannot be empty, null, or blank.")
    @ValidPhone(message = "Please provide a valid phone number.")
    private String phoneNumber;

    @Schema(name = "active", description = "Indica se o cliente está ativo", example = "true")
    private Boolean active;

    public String getDocumentNumber() {
        return CpfUtil.removeMask(this.documentNumber);
    }

}
