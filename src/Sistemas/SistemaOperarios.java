package Sistemas;

import Trabalhadores.Operario;
import Trabalhadores.Trabalhador;

import java.time.LocalDateTime;
import java.util.List;

public class SistemaOperarios extends Sistema {

    @Override
    public Trabalhador novoTrabalhadorModelo() {
        Trabalhador operario = new Operario();
        return operario;
    }

    @Override
    public Trabalhador novoTrabalhador(String nome, List<LocalDateTime> dados) {
        Trabalhador operario = new Operario(nome,dados);
        return operario;
    }
}
