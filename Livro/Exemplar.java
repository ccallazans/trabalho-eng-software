package Livro;

import java.util.ArrayList;

import LivroState.Disponivel;
import LivroState.Emprestado;
import LivroState.EstadoExemplar;

public class Exemplar {
    private Livro livro;
    private String codigoExemplar;
    private EstadoExemplar estado;

    public Exemplar(Livro livro, String codigoExemplar) {
        this.livro = livro;
        this.codigoExemplar = codigoExemplar;
        this.estado = new Disponivel(this);

    }

    public EstadoExemplar getEstado() {
        return estado;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public void setEstado(EstadoExemplar emprestado) {
        this.estado = emprestado;
    }
}
