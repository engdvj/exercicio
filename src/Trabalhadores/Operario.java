package Trabalhadores;

import java.time.LocalDateTime;
import java.util.List;
import Dados.DadosOperarios;

public class Operario implements Trabalhador{

    private String trabalhador = "operario";
    List<LocalDateTime> dados;
    public Operario (){ this.dados = DadosOperarios.gerarRegistros(); }
    public Operario (String trabalhador,List<LocalDateTime> dados){
        this.trabalhador = trabalhador;
        this.dados = dados;
    }
    public String getTrabalhador() {
        return trabalhador;
    }

    @Override
    public List<LocalDateTime> trabalhar() {
        rotinaTrabalho();
        return dados;
    }

    private void rotinaTrabalho() {
        for (int i = 0; i < dados.size(); i += 4) {
            LocalDateTime entrada = dados.get(i);
            LocalDateTime saidaAlmoco = dados.get(i + 1);
            LocalDateTime voltaAlmoco = dados.get(i + 2);
            LocalDateTime saida = dados.get(i + 3);

            // Calcula a duração de cada turno em minutos
            long minutosManha = java.time.temporal.ChronoUnit.MINUTES.between(entrada, saidaAlmoco);
            long minutosTarde = java.time.temporal.ChronoUnit.MINUTES.between(voltaAlmoco, saida);

            // Converte minutos em horas e minutos
            long horasManha = minutosManha / 60;
            long minutosRestantesManha = minutosManha % 60;

            long horasTarde = minutosTarde / 60;
            long minutosRestantesTarde = minutosTarde % 60;

            // Calcula o total de horas e minutos trabalhados no dia
            long totalMinutosTrabalhados = minutosManha + minutosTarde;
            long totalHorasTrabalhadas = totalMinutosTrabalhados / 60;
            long totalMinutosRestantes = totalMinutosTrabalhados % 60;

            // Limita o total de horas a 10 horas (8 horas regulares + 2 horas extras)
            if (totalHorasTrabalhadas > 10) {
                totalHorasTrabalhadas = 10;
                totalMinutosRestantes = 0; // Reseta os minutos restantes se o total de horas for limitado a 10
            }

            System.out.printf("Dia %d: Manhã - %dh:%dm, Tarde - %dh:%dm, Total Considerado - %dh:%dm%n",
                    (i / 4) + 1,
                    horasManha, minutosRestantesManha,
                    horasTarde, minutosRestantesTarde,
                    totalHorasTrabalhadas, totalMinutosRestantes);
        }
    }

}
