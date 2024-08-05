package med.voli.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voli.api.domain.endereco.DadosEndereco;

public record DadosCadastroPaciente(

        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotNull
        String telefone,

        @NotNull
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotNull @Valid DadosEndereco endereco) {
}
