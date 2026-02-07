package br.com.chiaro.config;

import br.com.chiaro.model.Perfil;
import br.com.chiaro.model.Usuario;
import br.com.chiaro.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AdminUserConfig(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var loginAdmin = "admin@chiaro.com";
        var user = repository.findByLogin(loginAdmin);

        if (user == null) {
            System.out.println("--- CRIANDO USUARIO ADMIN ---");
            user = new Usuario();
            user.setLogin(loginAdmin);
            user.setPerfil(Perfil.ADMIN);
            user.setAtivo(true);
        } else {
            System.out.println("--- ATUALIZANDO SENHA DO ADMIN (FIX) ---");
        }

        user.setSenha(passwordEncoder.encode("admin"));

        repository.save(user);
        System.out.println("--- USUARIO ADMIN PRONTO PARA USO ---");
    }
}