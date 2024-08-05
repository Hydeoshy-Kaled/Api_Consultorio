package med.voli.api.domain.consulta;

import med.voli.api.domain.medico.Medico;
import med.voli.api.domain.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByPacienteIdAndDataHoraBetween(Long pacienteId, LocalDateTime start, LocalDateTime end);
    boolean existsByMedicoIdAndDataHora(Long medicoId, LocalDateTime dataHora);



    @Query("SELECT c.medico FROM consultas c WHERE c.dataHora = :dataHora AND c.medico.ativo = true")
    Optional<Medico> findMedicoAtivo(LocalDateTime dataHora);

    @Query("SELECT c FROM consultas c WHERE c.dataHora = :dataHora")
    List<Consulta> findByDataHora(@Param("dataHora") LocalDateTime dataHora);


    boolean existsByPacienteAndCancelada(Paciente paciente, boolean consultaPacienteCancelada);

    boolean existsByMedicoAndCancelada(Medico medico, boolean consultaMedicoCancelada);

    Page <Consulta> findAllByCanceladaFalse(Pageable paginacao);
}
