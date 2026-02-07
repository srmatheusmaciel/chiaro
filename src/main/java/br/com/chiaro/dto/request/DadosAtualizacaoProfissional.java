package br.com.chiaro.dto.request;

import br.com.chiaro.model.Especialidade;
import jakarta.validation.constraints.NotNull;
import java.util.Set;

public record DadosAtualizacaoProfissional(
        @NotNull Long id,
        String nome,
        String cro,
        String corAgenda,
        Set<Especialidade> especialidades
) {}