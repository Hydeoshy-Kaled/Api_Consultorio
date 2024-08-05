package med.voli.api.controller;


import jakarta.validation.Valid;
import med.voli.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {


    @Autowired
    private PacienteRepository repositorio;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dados);
        repositorio.save(paciente);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(paciente.getId()).toUri();//cria o corpo inicial do endpoint (http://localhost) e cria um objeto uri
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPacientes>> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {

        var page = repositorio.findAllByAtivoTrue(paginacao).map(DadosListagemPacientes::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaPaciente dados) {
        var paciente = repositorio.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var paciente = repositorio.getReferenceById(id);
        paciente.excluir();

        return ResponseEntity.noContent().build();// Retorna mensagem 204 no Content(não tem conteudo) aplicando boas práticas

    }

    @GetMapping("/{id}")
    @jakarta.transaction.Transactional
    public ResponseEntity detalhar(@PathVariable Long id){// E um parametro do path ou seja do caminho
        var paciente = repositorio.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}
