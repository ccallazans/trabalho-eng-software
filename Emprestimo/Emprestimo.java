package Emprestimo;

import Livro.Livro;
import Usuario.Usuario;

import java.time.LocalDate;
import java.util.Date;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean isFinalizado = false;

    public Emprestimo(Usuario usuario, Livro livro, LocalDate limitDate) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();;
        this.dataDevolucao = limitDate;
    }

    public void setFinalizado(boolean finalizado) {
        isFinalizado = finalizado;
    }

    public String getStatus() {
        if (this.isFinalizado) {
            return "Finalizado";
        }
        return "Emprestado";
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

}
