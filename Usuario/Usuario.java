package Usuario;

import java.util.ArrayList;

import DevolverStrategy.DevolverStrategy;
import Emprestimo.Emprestimo;
import EmprestimoStrategy.EmprestimoStrategy;
import Livro.Livro;
import NotificarObserver.Observer;
import Reserva.Reserva;
import ReservarStrategy.ReservarStrategy;

public abstract class Usuario implements Observer {

    String codigoIdentificacao;
    String nome;
    Boolean devedor;
    int tempoDeEmprestimoDias;

    int qntNotificacoes;

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
    ArrayList<Emprestimo> allEmprestimos = new ArrayList<Emprestimo>();
    ArrayList<Reserva> allReservas = new ArrayList<Reserva>();

    public Usuario(String codigoIdentificacao, String nome) {
        this.codigoIdentificacao = codigoIdentificacao;
        this.nome = nome;
        this.devedor = false;
        this.qntNotificacoes = 0;
    }

    @Override
    public void update() {
        this.addQntNotificacoes();
    }

    public int getQntNotificacoes() {

        return qntNotificacoes;
    }

    public void addQntNotificacoes() {
        this.qntNotificacoes += 1;
    }

    public ArrayList<Emprestimo> getAllEmprestimos() {
        return allEmprestimos;
    }

    public ArrayList<Reserva> getAllReservas() {
        return allReservas;
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

    public void consulta() {
        System.out.println("Qnt Notificações: " + getQntNotificacoes());
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

    public void consultar() {
        System.out.println(
                "Usuário - Informações:\n" + this.getNome() +
                        "\nEmprestimos - Informações:");

        for (Emprestimo emprestimo: this.getAllEmprestimos()) {
            System.out.println("Título: " + emprestimo.getLivro().getTitulo() +
                    "\nData do Emprestimo: " + emprestimo.getDataEmprestimo() +
                    "\nStatus: " + emprestimo.getStatus() +
                    "\nData de Devolução: " + emprestimo.getDataDevolucao());
        }

        System.out.println("Reservas - Informações:");
        for (Reserva reserva: this.getReservas()) {
            System.out.println("Título: " + reserva.getLivro().getTitulo() +
                    "\nData da Reserva: " + reserva.getDataReserva());
        }
    }

    public boolean hasReservaByIdLivro(String id) {
        for (Reserva reserva: reservas) {
            if (reserva.getLivro().getCodigoIdentificacao().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void removeReservaByIdLivro(String id) {
        for (Reserva reserva: reservas) {
            if (reserva.getLivro().getCodigoIdentificacao().equals(id)) {
                reservas.remove(reserva);
                break;
            }
        }
    }
}
