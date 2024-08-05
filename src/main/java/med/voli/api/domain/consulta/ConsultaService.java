package med.voli.api.domain.consulta;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import med.voli.api.domain.medico.Medico;
import med.voli.api.domain.medico.MedicoRepository;
import med.voli.api.domain.paciente.Paciente;
import med.voli.api.domain.paciente.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Service

public class ConsultaService {






//    private final ConsultaRepository consultaRepository;
//    private final PacienteRepository pacienteRepository;
//    private final MedicoRepository medicoRepository;
//    //private final CancelamentoRepository cancelamentoRepository;
//
//    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
//        this.consultaRepository = consultaRepository;
//        this.pacienteRepository = pacienteRepository;
//        this.medicoRepository = medicoRepository;
//        //this.cancelamentoRepository = cancelamentoRepository;
//    }
//
//
//    public void agendarConsulta(@Valid DadosAgendamentoConsulta dados) {
//        LocalDateTime dataHora = dados.dataHora();
//
//        if (!isClinicaAberta(dataHora)) {
//            throw new IllegalArgumentException("Horário fora do funcionamento da clínica.");
//        }
//
//        if (!isComAntecedencia(dataHora)) {
//            throw new IllegalArgumentException("Consultas devem ser agendadas com antecedência mínima de 30 minutos.");
//        }
//
//        Paciente paciente = pacienteRepository.findByNome(dados.pacienteNome())
//                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado."));
//
//        if (!paciente.isAtivo()) {
//            throw new IllegalArgumentException("Paciente está inativo.");
//        }
//
//        if (consultaRepository.existsByPacienteIdAndDataHoraBetween(paciente.getId(), dataHora.toLocalDate().atStartOfDay(), dataHora.toLocalDate().atTime(23, 59))) {
//            throw new IllegalArgumentException("Paciente já possui consulta agendada neste dia.");
//        }
//
//        Medico medico;
//        if (dados.medicoNome() != null) {
//            medico = medicoRepository.findByNome(dados.medicoNome())
//                    .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado."));
//            if (!medico.isAtivo()) {
//                throw new IllegalArgumentException("Médico está inativo.");
//            }
//            if (consultaRepository.existsByMedicoIdAndDataHora(medico.getId(), dataHora)) {
//                throw new IllegalArgumentException("Médico já possui consulta agendada neste horário.");
//            }
//        } else {
//            medico = medicoRepository.findMedicoAtivo(dataHora)
//                    .orElseThrow(() -> new IllegalArgumentException("Nenhum médico disponível para o horário selecionado."));
//        }
//        boolean consultaPacienteAtiva = consultaRepository.existsByPacienteAndCancelada(paciente,false);
//        boolean consultaPacienteCancelada = consultaRepository.existsByPacienteAndCancelada(paciente,true);
//        boolean consultaMedicoAtiva = consultaRepository.existsByMedicoAndCancelada(medico,false);
//        boolean consultaMedicoCancelada = consultaRepository.existsByMedicoAndCancelada(medico,true);
//        Consulta consulta = new Consulta(null, null, paciente, medico, dataHora, paciente.getNomeAsString(), medico.getNomeAsString(), false);
//
//
//        if(consultaPacienteAtiva && !consultaPacienteCancelada){
//            throw new ValidationException("O paciente já possui uma consulta marcada.");
//        }
//
//
//        consultaRepository.save(consulta);
////                new Consulta(null,null,paciente,medico,consulta.getNomePaciente(),consulta.getNomeMedico(),dataHora,false));
//
//
//    }
//
//    public void cancelarConsulta(Long id, String motivoCancelamento) {
//        Consulta consulta = consultaRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada"));
//        if (!isCancelamentoAntecedencia(consulta.getDataHora())) {
//            throw new IllegalArgumentException("Consultas só podem ser canceladas com antecedência mínima de 24 horas.");
//        }
//
//        if (!isMotivoValido(motivoCancelamento)) {
//            throw new IllegalArgumentException("Motivo de cancelamento inválido.");
//        }
//        consulta.setCancelada(true);
//        consulta.setMotivoCancelamento(motivoCancelamento);
//        consultaRepository.save(consulta);
//
//    }
//
//    private boolean isClinicaAberta(LocalDateTime dataHora) {
//        DayOfWeek day = dataHora.getDayOfWeek();
//        int hour = dataHora.getHour();
//        return (day != DayOfWeek.SUNDAY) && (hour >= 7 && hour < 19);
//    }
//
//    private boolean isComAntecedencia(LocalDateTime dataHora) {
//        return dataHora.isAfter(LocalDateTime.now().plusMinutes(30));
//    }
//    private boolean isCancelamentoAntecedencia(LocalDateTime dataHora) {
//        return dataHora.isAfter(LocalDateTime.now().plusHours(24));
//    }
//
//    private boolean isMotivoValido(String motivo) {
//        String motivoLimpo = motivo.trim();
//        return motivoLimpo.equals("paciente desistiu") || motivoLimpo.equals("médico cancelou") || motivoLimpo.equals("outros");
//    }
//
//    public Page<DadosListagemConsultas> listarConsultas(Pageable paginacao) {
//        return consultaRepository.findAll(paginacao).map(DadosListagemConsultas::new);
//    }


}
