package Livro;

import Usuario.Usuario;

public class Reserva {
    Usuario usuario;
    Livro livro;

    public Reserva(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
