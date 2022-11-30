package Biblioteca;

import Livro.Emprestimo;
import Livro.Exemplar;
import Livro.Reserva;
import Usuario.Usuario;

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
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }
    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public Usuario getUsuario(int codigoUsuario) {
        for (Usuario usuario: usuarios) {
            if (usuario.getCodigoIdentificacao() == codigoUsuario) {
                return usuario;
            }
        }
        return null;
    }
    public boolean isExemplar(int codigoLivro) {
        for (Exemplar exemplar: this.exemplares) {
            if (exemplar.getLivro().getCodigoIdentificacao() == codigoLivro && exemplar.status) {
                return true;
            }
        }
        return false;
    }
    public int getQuantidadeExemplarLivro(int codigoLivro) {
        int qnt = 0;
        for (Exemplar exemplar: exemplares) {
            if (exemplar.getLivro().getCodigoIdentificacao() == codigoLivro && exemplar.status) {
                qnt += 1;
            }
        }
        return qnt;
    }
    public int getQuantidadeReservaLivro(int codigoLivro) {
        int qnt = 0;
        for (Reserva reserva: reservas) {
            if (reserva.getLivro().getCodigoIdentificacao() == codigoLivro) {
                qnt += 1;
            }
        }
        return qnt;
    }
    public boolean isUsuarioLivroReserva(int codigoUsuario, int codigoLivro) {
        for (Reserva reserva: reservas) {
            if (reserva.getUsuario().getCodigoIdentificacao() == codigoUsuario && reserva.getLivro().getCodigoIdentificacao() == codigoLivro) {
                return true;
            }
        }
        return false;
    }

    public void criarEmprestimo(int codigoUsuario, int codigoLivro){
        if (!isExemplar(codigoLivro)) {
            System.out.println("Erro: Exemplar não disponível");
            return;
        }

        Usuario usuario = this.getUsuario(codigoUsuario);
        if (!usuario.validarEmprestimo(codigoLivro)) {
            return;
        }
    }

}