package med.voli.api.domain.consulta;

import jakarta.persistence.*;
import lombok.*;
import med.voli.api.domain.medico.Medico;
import med.voli.api.domain.paciente.Paciente;

import java.time.LocalDateTime;



@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {




      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "medico_id")
      private Medico medico;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "paciente_id")
      private Paciente paciente;

      private LocalDateTime data;

   }
//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private Long id;
//
//
//   @ManyToOne(fetch = FetchType.LAZY)
//   @JoinColumn(name = "paciente_id")
//   private Paciente paciente ;
//
//   @ManyToOne(fetch = FetchType.LAZY)
//   @JoinColumn(name = "medico_id")
//   private Medico medico;
//
//   private LocalDateTime dataHora;
//
//   @ManyToOne(fetch = FetchType.LAZY)
//   private String nomePaciente;
//
//   @ManyToOne(fetch = FetchType.LAZY)
//   private String nomeMedico;
//
//   private  boolean cancelada;
//   private String motivoCancelamento;
//
//
//   public Consulta(Long id,String motivoCancelamento,Paciente paciente, Medico medico, LocalDateTime dataHora, boolean cancelada) {
//      this.id = id;
//      this.paciente = paciente;
//      this.medico = medico;
//      this.dataHora = dataHora;
//      this.nomePaciente = paciente.getNome();
//      this.nomeMedico = medico.getNome();
//      this.motivoCancelamento = motivoCancelamento;
//      this.cancelada = cancelada;
//   }
//
//    public Consulta(DadosAgendamentoConsulta dados) {
//      this.nomePaciente = dados.pacienteNome();
//      this.nomeMedico = dados.medicoNome();
//      this.dataHora = dados.dataHora();
//    }
//
//
////    public void setNomePaciente(String nomePaciente) {
////      if (this.paciente == null) {
////         this.nomePaciente = paciente.getNome();
////      }
////      this.paciente.setNome(nomePaciente);
////   }
//
//   public Long getId() {
//      return id;
//   }
//
//   public void setId(Long id) {
//      this.id = id;
//   }
//
//   public Paciente getPaciente() {
//      return paciente;
//   }
//
//   public void setPaciente(Paciente paciente) {
//      this.paciente = paciente;
//   }
//
//   public Medico getMedico() {
//      return medico;
//   }
//
//   public void setMedico(Medico medico) {
//      this.medico = medico;
//
//   }
//
//   public LocalDateTime getDataHora() {
//      return dataHora;
//   }
//
//   public void setDataHora(LocalDateTime dataHora) {
//      this.dataHora = dataHora;
//   }
//
//   public boolean isCancelada() {
//      return cancelada=true;
//   }
//
//   public void setCancelada(boolean cancelada) {
//      this.cancelada = cancelada;
//   }
//
//   public String getMotivoCancelamento() {
//      return motivoCancelamento;
//   }
//
//   public void setMotivoCancelamento(String motivoCancelamento) {
//      this.motivoCancelamento = motivoCancelamento;
//   }
//
//   public String getNomePaciente() {
//      return nomePaciente;
//   }
//
//   public String getNomeMedico() {
//      return nomeMedico;
//   }
//
//   public void setNomeMedico(String nomeMedico) {
//      this.nomeMedico = nomeMedico;
//   }

