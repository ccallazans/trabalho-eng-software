package Livro;


import Usuario.Usuario;

public class Emprestimo {
    Usuario usuario;
    Livro livro;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public Livro getLivro() {
        return livro;
    }
}
