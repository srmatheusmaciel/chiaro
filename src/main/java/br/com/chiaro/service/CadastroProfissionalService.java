package br.com.chiaro.service;

import br.com.chiaro.dto.request.DadosCadastroProfissional;
import br.com.chiaro.model.Perfil;
import br.com.chiaro.model.Profissional;
import br.com.chiaro.model.Usuario;
import br.com.chiaro.repository.ProfissionalRepository;
import br.com.chiaro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroProfissionalService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Profissional cadastrar(DadosCadastroProfissional dados) {
        var usuario = new Usuario();
        usuario.setLogin(dados.email());
        usuario.setSenha(passwordEncoder.encode(dados.senha()));
        usuario.setPerfil(Perfil.DENTISTA);
        usuario.setAtivo(true);

        usuario = usuarioRepository.save(usuario);

        var profissional = new Profissional();
        profissional.setNome(dados.nome());
        profissional.setCro(dados.cro());
        profissional.setEspecialidades(dados.especialidades());
        profissional.setCorAgenda(dados.corAgenda());
        profissional.setUsuario(usuario);

        return profissionalRepository.save(profissional);
    }
}