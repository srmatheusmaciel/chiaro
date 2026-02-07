package br.com.chiaro.dto.request;

import br.com.chiaro.model.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Set;

public record DadosCadastroProfissional(
        @NotBlank
        String nome,

        @NotBlank @Email
        String email,

        @NotBlank
        String senha,

        @NotBlank
        String cro,

        @NotNull
        Set<Especialidade> especialidades,

        String corAgenda // (Ex: #FF0000)
) {}