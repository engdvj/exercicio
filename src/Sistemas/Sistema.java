package Sistemas;

import Trabalhadores.Trabalhador;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Sistema{

    public abstract Trabalhador novoTrabalhadorModelo();
    public abstract Trabalhador novoTrabalhador(String nome,List<LocalDateTime> dados);


}
