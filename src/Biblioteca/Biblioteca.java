package Biblioteca;

import Livro.Exemplar;
import Livro.Livro;
import Usuario.Usuario;
import Livro.Emprestimo;
import Livro.Reserva;

import java.util.ArrayList;

public class Biblioteca {
    static ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    static ArrayList<Emprestimo> emprestimos  = new ArrayList<Emprestimo>();
    static ArrayList<Reserva> reservas  = new ArrayList<Reserva>();

    public void adicionarExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
    }

    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public Usuario getUsuario(int codigoUsuario) {
        for (Usuario u: usuarios) {
            if (u.codigoIdentificacao == codigoUsuario) {
                return u;
            }
        }
        return null;
    }

    public boolean exemplarDisponivel(int codigoLivro) {
        for (Exemplar e: exemplares) {
            if (e.getCodigoLivro() == codigoLivro && e.isDisponivel()) {
                return true;
            }
        }
        return false;
    }

    public void adicionarEmprestimo(int codigoUsuario, int codigoLivro) {
        if (!exemplarDisponivel(codigoLivro)){
            return;
        }

        Usuario u = getUsuario(codigoUsuario);
    }

}
