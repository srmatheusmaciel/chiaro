package br.com.chiaro.dto.response;

import br.com.chiaro.model.Especialidade;
import br.com.chiaro.model.Profissional;
import java.util.Set;

public record DadosDetalhamentoProfissional(
        Long id,
        String nome,
        String cro,
        String email,
        Set<Especialidade> especialidades,
        String corAgenda,
        Boolean ativo
) {
    public DadosDetalhamentoProfissional(Profissional p) {
        this(
                p.getId(),
                p.getNome(),
                p.getCro(),
                p.getUsuario().getLogin(),
                p.getEspecialidades(),
                p.getCorAgenda(),
                p.getAtivo()
        );
    }
}