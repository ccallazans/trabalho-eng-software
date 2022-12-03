package Livro;

import java.util.ArrayList;

import LivroState.Disponivel;
import LivroState.Emprestado;
import LivroState.EstadoExemplar;
import Emprestimo.Emprestimo;

public class Exemplar {
    private Livro livro;
    private String codigoExemplar;
    private EstadoExemplar estado;
    private Emprestimo ultimoEmprestimo;

    public Exemplar(Livro livro, String codigoExemplar) {
        this.livro = livro;
        this.codigoExemplar = codigoExemplar;
        this.estado = new Disponivel(this);

    }

    public Emprestimo getUltimoEmprestimo() {
        return ultimoEmprestimo;
    }

    public void setUltimoEmprestimo(Emprestimo ultimoEmprestimo) {
        this.ultimoEmprestimo = ultimoEmprestimo;
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

    public String getStatusString() {
        if (this.estado.status == true) {
            return "Disponível";
        } else {
            return "Emprestado";
        }
    }

}
