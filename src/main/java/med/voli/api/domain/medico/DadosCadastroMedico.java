package med.voli.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voli.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(

        @NotBlank //Bean Validation verifica se o nome esta vazio ou nulo
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @Valid
        @NotNull
        DadosEndereco endereco) {}

