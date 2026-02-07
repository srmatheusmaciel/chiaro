package br.com.chiaro.model;

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

}