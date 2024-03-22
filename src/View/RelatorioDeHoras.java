package View;

import Trabalhadores.Trabalhador;

public class RelatorioDeHoras {

    private CalculadoraDeHoras calculadora;

    public RelatorioDeHoras() {
        this.calculadora = new CalculadoraDeHoras();
    }

    public void gerarRelatorioParaTrabalhador(Trabalhador trabalhador) {
        int totalHoras = calculadora.calcularSaldoHoras(trabalhador);
        System.out.printf("\n-> Total de horas na semana para %s: %dh\n", trabalhador.getTrabalhador(), totalHoras);
        // Aqui você pode adicionar mais lógica para detalhes diários, se necessário.
    }
}