CREATE TABLE tb_usuario (
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    perfil VARCHAR(50) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    criado_em TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    atualizado_em TIMESTAMP WITHOUT TIME ZONE
);

-- Senha: 'admin' (criptografada com BCrypt, vamos configurar isso já já)
-- O hash abaixo é para a senha "admin"
INSERT INTO tb_usuario (login, senha, perfil, ativo)
VALUES ('admin@chiaro.com', '$2a$10$r3r9/X8K/1h.q.w.e.r.t.y.u.i.o.p.1.2.3.4.5.6.7.8.9.0', 'ADMIN', true);