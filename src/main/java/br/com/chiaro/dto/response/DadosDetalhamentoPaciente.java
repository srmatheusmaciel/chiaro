package br.com.chiaro.dto.response;

import br.com.chiaro.model.Anamnese;
import br.com.chiaro.model.Endereco;
import br.com.chiaro.model.Paciente;
import br.com.chiaro.model.Sexo;

import java.time.LocalDate;

public record DadosDetalhamentoPaciente(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone,
        LocalDate dataNascimento,
        Sexo sexo,
        Endereco endereco,
        Anamnese anamnese
) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf(),
                paciente.getTelefone(),
                paciente.getDataNascimento(),
                paciente.getSexo(),
                paciente.getEndereco(),
                paciente.getAnamnese()
        );
    }
}