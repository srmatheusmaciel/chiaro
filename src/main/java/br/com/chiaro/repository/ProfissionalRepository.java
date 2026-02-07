package br.com.chiaro.repository;

import br.com.chiaro.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    List<Profissional> findAllByAtivoTrue();

    @Query("SELECT p FROM Profissional p WHERE p.usuario.id = :usuarioId")
    Profissional buscarPorUsuarioId(Long usuarioId);
}