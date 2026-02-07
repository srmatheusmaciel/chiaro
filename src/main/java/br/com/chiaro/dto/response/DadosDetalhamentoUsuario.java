package br.com.chiaro.dto.response;

import br.com.chiaro.model.Perfil;
import br.com.chiaro.model.Usuario;

public record DadosDetalhamentoUsuario(Long id, String login, Perfil perfil, Boolean ativo) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getPerfil(), usuario.getAtivo());
    }
}