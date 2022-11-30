package Usuario;

import Biblioteca.Biblioteca;
import Notificacao.Observer;

public abstract class Usuario implements Observer {
    int codigoIdentificacao;
    String nome;
    static Biblioteca biblioteca;
    boolean devedor = false;

    public Usuario(int codigoIdentificacao, String nome) {
        this.codigoIdentificacao = codigoIdentificacao;
        this.nome = nome;
    }

    public int getCodigoIdentificacao() {
        return codigoIdentificacao;
    }
    public String getNome() {
        return nome;
    }

    public boolean isDevedor() {
        return devedor;
    }


    public boolean validarEmprestimo(int codigoLivro) {
        return false;
    }
}
