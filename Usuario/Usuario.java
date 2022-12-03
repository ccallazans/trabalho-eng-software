package Usuario;

import java.util.ArrayList;

import DevolverStrategy.DevolverStrategy;
import Emprestimo.Emprestimo;
import EmprestimoStrategy.EmprestimoStrategy;
import Livro.Livro;
import Observable.Observer;
import Reserva.Reserva;
import ReservarStrategy.ReservarStrategy;

public abstract class Usuario implements Observer {

    String codigoIdentificacao;
    String nome;
    Boolean devedor;
    int tempoDeEmprestimoDias;

    ReservarStrategy reservaStrategy;
    DevolverStrategy devolverStrategy;

    public DevolverStrategy getDevolverStrategy() {
        return devolverStrategy;
    }

    public Boolean getDevedor() {
        return devedor;
    }

    public void setDevedor(Boolean devedor) {
        this.devedor = devedor;
    }

    public EmprestimoStrategy getEmprestimoStrategy() {
        return emprestimoStrategy;
    }

    public void setEmprestimoStrategy(EmprestimoStrategy emprestimoStrategy) {
        this.emprestimoStrategy = emprestimoStrategy;
    }

    EmprestimoStrategy emprestimoStrategy;

    ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    public Usuario(String codigoIdentificacao, String nome) {
        this.codigoIdentificacao = codigoIdentificacao;
        this.nome = nome;
        this.devedor = false;
    }

    public String getCodigoIdentificacao() {
        return codigoIdentificacao;
    }

    public void setCodigoIdentificacao(String codigoIdentificacao) {
        this.codigoIdentificacao = codigoIdentificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void reservar(Livro livro, String data) {
        this.reservas.add(new Reserva(livro, this));
    }

    public ReservarStrategy getReservaStrategy() {
        return reservaStrategy;
    }

    public void setReservaStrategy(ReservarStrategy reservaStrategy) {
        this.reservaStrategy = reservaStrategy;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void pegarEmprestado() {

    }

    public Emprestimo EncontrarEmprestimoPorIdLivro(String id) {
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getLivro().getCodigoIdentificacao().equals(id)) {
                return emprestimo;
            }
        }
        return null;
    }

    public boolean hasEmprestimoPorIdLivro(String id) {
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getLivro().getCodigoIdentificacao().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public int getTempoDeEmprestimoDias() {
        return tempoDeEmprestimoDias;
    }
}
