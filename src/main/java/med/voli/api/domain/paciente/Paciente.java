package med.voli.api.domain.paciente;

import jakarta.persistence.*;
import lombok.*;
import med.voli.api.domain.consulta.Consulta;
import med.voli.api.domain.endereco.Endereco;

import java.util.List;


@Table(name = "pacientes")
@Entity(name = "paciente")
@Data
@NoArgsConstructor //Gera todos os construtores exigidos pela JPA
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private Endereco endereco;

    private boolean ativo;

    //@JsonIgnore
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Consulta> consultas;

    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void excluir(){
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizaPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.nome = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public boolean isAtivo() {
        return this.ativo = true;
    }
}

