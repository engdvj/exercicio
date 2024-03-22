package View;

import Sistemas.Sistema;
import Sistemas.SistemaOperarios;
import Trabalhadores.Trabalhador;

import java.time.LocalDateTime;
import java.util.List;

public class GerenciadorDeTrabalhadores {

    private Sistema sistemaOperarios;

    public GerenciadorDeTrabalhadores() {
        this.sistemaOperarios = new SistemaOperarios();
    }

    public Trabalhador criarOperarioModelo() {
        return sistemaOperarios.novoTrabalhadorModelo();
    }

    public Trabalhador criarOperario(String nome, List<LocalDateTime> registrosDePonto) {
        return sistemaOperarios.novoTrabalhador(nome, registrosDePonto);
    }
}