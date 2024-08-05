package med.voli.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    boolean existsByAtivoTrue();

    @Query("SELECT m FROM Medico m WHERE m.ativo = true AND NOT EXISTS (SELECT c FROM consultas c WHERE c.medico = m AND c.dataHora = :dataHora)")
    Optional<Medico> findMedicoAtivo(LocalDateTime dataHora);

    Optional<Medico> findByNome(String nome);
}
