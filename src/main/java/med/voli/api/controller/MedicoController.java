package med.voli.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repositorio;


    @PostMapping
    @Transactional // Transação ativa com BD
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        repositorio.save(medico);

           var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();//cria o corpo inicial do endpoint (http://localhost) e cria um objeto uri

           return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>> listarMedico(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){// Se não for informado os padrões de exibições
                                                                                                                    // este é o padrão maximo de 10 por página e pela palavra nome
        var page = repositorio.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
        return ResponseEntity.ok(page);// retorna o codigo 200 e conteudo listado
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaMedico dados){
        var medico = repositorio.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));//Precisa retornar 200 OK + o corpo da resposta.
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity exclulir(@PathVariable Long id){// E um parametro do path ou seja do caminho
        var medico = repositorio.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();// Retorna o erro 204 no Content(não tem conteudo) aplicando boas práticas
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar(@PathVariable Long id){// E um parametro do path ou seja do caminho
        var medico = repositorio.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

}
