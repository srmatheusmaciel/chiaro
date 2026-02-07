package br.com.chiaro.dto.request;

import br.com.chiaro.model.Anamnese;
import br.com.chiaro.model.Sexo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos")
        String cpf,

        @NotNull
        LocalDate dataNascimento,

        @NotNull
        Sexo sexo,

        @NotNull
        @Valid
        DadosEndereco endereco,

        Anamnese anamnese
) {}