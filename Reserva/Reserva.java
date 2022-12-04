package Reserva;

import Livro.Livro;
import Usuario.Usuario;

import java.time.LocalDate;

public class Reserva {
    private String data;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataReserva;

    public Reserva(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataReserva = LocalDate.now();
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
