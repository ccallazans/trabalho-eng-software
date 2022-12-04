package Usuario;

import DevolverStrategy.Devolver;
import EmprestimoStrategy.EmprestimoProfessor;
import Livro.Livro;
import ReservarStrategy.ReservaProfessor;

public class Professor extends Usuario {


    private int qtdNotificacoes;

    public Professor(String codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
        this.qtdNotificacoes = 0;
        this.reservaStrategy = new ReservaProfessor();
        this.emprestimoStrategy = new EmprestimoProfessor();
        this.devolverStrategy = new Devolver();
        this.tempoDeEmprestimoDias = 7;

    }


    public int getQtdNotificacoes() {
        return qtdNotificacoes;
    }

    public void setQtdNotificacoes(int qtdNotificacoes) {
        this.qtdNotificacoes = qtdNotificacoes;
    }

    @Override
    public void reservar(Livro livro, String data) {
        this.reservaStrategy.reservar(this, livro, data);
    }

}
