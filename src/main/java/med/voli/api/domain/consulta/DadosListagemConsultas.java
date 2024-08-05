package med.voli.api.domain.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voli.api.domain.medico.Medico;
import med.voli.api.domain.paciente.Paciente;
import org.hibernate.annotations.Bag;

import java.time.LocalDateTime;


public record DadosListagemConsultas(

     @NotNull
     Long id,

     @NotBlank
     Paciente paciente,

     @NotBlank
     Medico medico,

     @NotBlank
     String nomePaciente,

     @NotBlank
     String nomeMedico,

     @NotNull
     LocalDateTime dataHora){

//    public DadosListagemConsultas(Consulta consulta) {
//       this(consulta.getId(), consulta.getPaciente().getNome(), consulta.getMedico(), consulta.getNomePaciente(), consulta.getNomeMedico(), consulta.getDataHora());
//    }
}
