package View;

import Dados.DadosOperarios;
import Trabalhadores.Trabalhador;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeTrabalhadores gerenciador = new GerenciadorDeTrabalhadores();
        RelatorioDeHoras relatorio = new RelatorioDeHoras();

        Trabalhador operarioModelo = gerenciador.criarOperarioModelo();
        relatorio.gerarRelatorioParaTrabalhador(operarioModelo);

        Trabalhador operarioMateus = gerenciador.criarOperario("Mateus", DadosOperarios.registrosDePonto);
        relatorio.gerarRelatorioParaTrabalhador(operarioMateus);
    }
}