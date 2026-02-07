package br.com.chiaro.model;

import br.com.chiaro.dto.request.DadosAtualizacaoProfissional;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "tb_profissional")
@Entity(name = "Profissional")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profissional {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    private String nome;

    private String cro;

    @ElementCollection(targetClass = Especialidade.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_profissional_especialidades", joinColumns = @JoinColumn(name = "profissional_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade")
    private Set<Especialidade> especialidades;

    private String corAgenda; // Ex: #FF5733 (Para diferenciar no calendário)

    private Boolean ativo = true;

    public void atualizarInformacoes(DadosAtualizacaoProfissional dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.cro() != null) this.cro = dados.cro();
        if (dados.corAgenda() != null) this.corAgenda = dados.corAgenda();
        if (dados.especialidades() != null) {
            this.especialidades.clear();
            this.especialidades.addAll(dados.especialidades());
        }
    }

    public void inativar() {
        this.ativo = false;
        this.usuario.inativar();
    }

}