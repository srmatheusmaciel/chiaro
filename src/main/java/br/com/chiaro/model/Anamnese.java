package br.com.chiaro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Anamnese implements Serializable {

    private String queixaPrincipal;

    private Boolean hipertensao = false;
    private Boolean diabetes = false;
    private Boolean problemasCardiacos = false;
    private String outrasDoencas;

    private List<String> medicamentosEmUso = new ArrayList<>();
    private List<String> alergias = new ArrayList<>();

    private Boolean fumante = false;
    private Boolean etilista = false;

    private String observacoesGerais;
}