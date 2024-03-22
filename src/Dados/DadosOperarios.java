package Dados;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DadosOperarios {
    public static final LocalDateTime DATA_INICIAL = LocalDateTime.of(2024, 3, 4, 0, 0); // Segunda-feira, 4 de março de 2024
    public static List<LocalDateTime> registrosDePonto = List.of(
            // Segunda-feira, 4 de março
            DATA_INICIAL.withHour(6).withMinute(15), // Entrada (um pouco atrasado)
            DATA_INICIAL.withHour(12).withMinute(5), // Saída para almoço
            DATA_INICIAL.withHour(13).withMinute(10), // Volta do almoço (um pouco atrasado)
            DATA_INICIAL.withHour(19).withMinute(30), // Saída (ficou um pouco mais tarde)

            // Terça-feira, 5 de março
            DATA_INICIAL.plusDays(1).withHour(8).withMinute(0), // Entrada
            DATA_INICIAL.plusDays(1).withHour(11).withMinute(50), // Saída para almoço (um pouco mais cedo)
            DATA_INICIAL.plusDays(1).withHour(12).withMinute(40), // Volta do almoço (almoço rápido)
            DATA_INICIAL.plusDays(1).withHour(17).withMinute(15), // Saída (ficou um pouco mais tarde)

            // Quarta-feira, 6 de março
            DATA_INICIAL.plusDays(2).withHour(8).withMinute(30), // Entrada (bastante atrasado)
            DATA_INICIAL.plusDays(2).withHour(12).withMinute(15), // Saída para almoço
            DATA_INICIAL.plusDays(2).withHour(13).withMinute(15), // Volta do almoço
            DATA_INICIAL.plusDays(2).withHour(18).withMinute(0), // Saída (compensou o atraso)

            // Quinta-feira, 7 de março
            DATA_INICIAL.plusDays(3).withHour(7).withMinute(45), // Entrada (chegou mais cedo)
            DATA_INICIAL.plusDays(3).withHour(12).withMinute(30), // Saída para almoço (almoço mais tarde)
            DATA_INICIAL.plusDays(3).withHour(13).withMinute(30), // Volta do almoço
            DATA_INICIAL.plusDays(3).withHour(17).withMinute(0), // Saída

            // Sexta-feira, 8 de março
            DATA_INICIAL.plusDays(4).withHour(8).withMinute(5), // Entrada
            DATA_INICIAL.plusDays(4).withHour(12).withMinute(0), // Saída para almoço
            DATA_INICIAL.plusDays(4).withHour(13).withMinute(0), // Volta do almoço
            DATA_INICIAL.plusDays(4).withHour(16).withMinute(45)  // Saída (saiu um pouco mais cedo)
    );

    public static List<LocalDateTime> gerarRegistros() {
        List<LocalDateTime> registros = new ArrayList<>();
        LocalDateTime dataInicial = DadosOperarios.DATA_INICIAL; // Usa a variável estática como data inicial

        for (int i = 0; i < 7; i++) { // Considera os 7 dias da semana para esse exemplo
            LocalDateTime dia = dataInicial.plusDays(i);
            // Ignora fins de semana
            if (!(dia.getDayOfWeek() == DayOfWeek.SATURDAY || dia.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                registros.add(dia.withHour(7).withMinute(0)); // Hora da entrada ajustada para 7h
                registros.add(dia.withHour(12)); // Hora do almoço (12h)
                registros.add(dia.withHour(13)); // Volta do almoço (13h)
                registros.add(dia.withHour(18)); // Fim do expediente (18h)
            }
        }
        return registros;
    }
}