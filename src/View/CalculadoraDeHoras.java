package View;

import Trabalhadores.Trabalhador;

import java.time.temporal.ChronoUnit;
import java.time.*;
import java.util.*;


public class CalculadoraDeHoras {
    private Set<LocalDate> feriados = Set.of(
            LocalDate.of(2024, 1, 1),  // Ano Novo
            LocalDate.of(2024, 2, 12), // Carnaval (Terça-feira)
            LocalDate.of(2024, 2, 13), // Quarta-feira de Cinzas (ponto facultativo até as 14h)
            LocalDate.of(2024, 3, 29), // Sexta-feira Santa
            LocalDate.of(2024, 4, 21), // Tiradentes
            LocalDate.of(2024, 5, 1),  // Dia do Trabalho
            LocalDate.of(2024, 5, 30), // Corpus Christi
            LocalDate.of(2024, 9, 7),  // Independência do Brasil
            LocalDate.of(2024, 10, 12),// Nossa Senhora Aparecida
            LocalDate.of(2024, 11, 2), // Finados
            LocalDate.of(2024, 11, 15),// Proclamação da República
            LocalDate.of(2024, 12, 25) // Natal
    );

    public int calcularSaldoHoras(Trabalhador trabalhador) {
        List<LocalDateTime> registros = trabalhador.trabalhar();
        long saldoTotalMinutos = calcularTotalMinutosTrabalhados(registros);

        return (int) (saldoTotalMinutos / 60); // Converte o saldo total de minutos para horas
    }

    public static long calcularTotalMinutosTrabalhados(List<LocalDateTime> registros) {
        long totalMinutos = 0;
        for (int i = 0; i < registros.size(); i += 4) {
            LocalDateTime entrada = registros.get(i);
            LocalDateTime saidaAlmoco = registros.get(i + 1);
            LocalDateTime voltaAlmoco = registros.get(i + 2);
            LocalDateTime saida = registros.get(i + 3);

            long minutosManha = ChronoUnit.MINUTES.between(entrada, saidaAlmoco);
            long minutosTarde = ChronoUnit.MINUTES.between(voltaAlmoco, saida);

            long totalMinutosTrabalhadosDia = minutosManha + minutosTarde;
            long minutosExcedentesDia = Math.max(0, totalMinutosTrabalhadosDia - (8 * 60)); // Calcula minutos excedentes além das 8 horas padrão
            minutosExcedentesDia = Math.min(minutosExcedentesDia, 2 * 60); // Limita o excesso a 2 horas

            totalMinutos += (8 * 60) + minutosExcedentesDia; // Soma 8 horas padrão mais até 2 horas extras permitidas
        }
        return totalMinutos;
    }

}