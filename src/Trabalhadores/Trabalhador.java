package Trabalhadores;

import java.time.LocalDateTime;
import java.util.List;

public interface Trabalhador {
    String getTrabalhador();
    List<LocalDateTime> trabalhar();
}
