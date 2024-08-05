package med.voli.api.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voli.api.domain.consulta.ConsultaRepository;
import med.voli.api.domain.consulta.ConsultaService;
import med.voli.api.domain.consulta.DadosAgendamentoConsulta;
import med.voli.api.domain.consulta.DadosDetalhamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("consultas")
@RequiredArgsConstructor
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private ConsultaRepository consultaRepository;



    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        System.out.println(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }
//
//    @GetMapping
//    public ResponseEntity<Page<DadosListagemConsultas>> listarConsultas(@PageableDefault(size = 10, sort = {"dataHora"}) Pageable paginacao) {
//
//        var page = consultaRepository.findAllByCanceladaFalse(paginacao).map(DadosListagemConsultas::new);
//        return ResponseEntity.ok(page);
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity<Void> cancelarConsulta(@PathVariable Long id, @RequestBody Map<String, String> payload) {
//        String motivoCancelamento = payload.get("motivoCancelamento");
//        consultaService.cancelarConsulta(id, motivoCancelamento);
//        return ResponseEntity.noContent().build();
//    }
//


}
