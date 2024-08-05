package med.voli.api.domain.consulta;

import med.voli.api.domain.medico.Medico;
import med.voli.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta (Long id, Long idMedico, Long idPaciente, LocalDateTime datahora) {

}
