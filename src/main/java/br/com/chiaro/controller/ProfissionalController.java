package br.com.chiaro.controller;

import br.com.chiaro.dto.request.DadosAtualizacaoProfissional;
import br.com.chiaro.dto.request.DadosCadastroProfissional;
import br.com.chiaro.dto.response.DadosDetalhamentoProfissional;
import br.com.chiaro.repository.ProfissionalRepository;
import br.com.chiaro.service.CadastroProfissionalService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/profissionais")
@SecurityRequirement(name = "bearer-key")
@RequiredArgsConstructor
public class ProfissionalController {

    private CadastroProfissionalService service;

    private ProfissionalRepository repository;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProfissional dados, UriComponentsBuilder uriBuilder) {
        var profissional = service.cadastrar(dados);

        var uri = uriBuilder.path("/profissionais/{id}").buildAndExpand(profissional.getId()).toUri();
        return ResponseEntity.created(uri).body(profissional);
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoProfissional>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosDetalhamentoProfissional::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProfissional dados) {
        var profissional = repository.getReferenceById(dados.id());
        profissional.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoProfissional(profissional));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity excluir(@PathVariable Long id) {
        var profissional = repository.getReferenceById(id);
        profissional.inativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var profissional = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoProfissional(profissional));
    }

}