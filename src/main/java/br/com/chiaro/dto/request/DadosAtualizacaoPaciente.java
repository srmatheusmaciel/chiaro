package br.com.chiaro.dto.request;

import br.com.chiaro.model.Anamnese;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco,
        Anamnese anamnese
) {}