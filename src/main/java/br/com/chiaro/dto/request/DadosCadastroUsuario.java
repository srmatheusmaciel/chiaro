package br.com.chiaro.dto.request;

import br.com.chiaro.model.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(
        @NotBlank @Email
        String login,

        @NotBlank
        String senha,

        @NotNull
        Perfil perfil
) {}