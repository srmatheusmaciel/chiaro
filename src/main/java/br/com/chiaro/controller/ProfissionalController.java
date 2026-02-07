package br.com.chiaro.controller;

import br.com.chiaro.dto.request.DadosCadastroProfissional;
import br.com.chiaro.service.CadastroProfissionalService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/profissionais")
@SecurityRequirement(name = "bearer-key")
public class ProfissionalController {

    @Autowired
    private CadastroProfissionalService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProfissional dados, UriComponentsBuilder uriBuilder) {
        var profissional = service.cadastrar(dados);

        var uri = uriBuilder.path("/profissionais/{id}").buildAndExpand(profissional.getId()).toUri();
        return ResponseEntity.created(uri).body(profissional);
    }

}