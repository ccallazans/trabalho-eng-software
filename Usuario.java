import java.util.ArrayList;

public abstract class Usuario implements Observer {

    String codigoIdentificacao;
    String nome;

    ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public Usuario(String codigoIdentificacao, String nome) {
        this.codigoIdentificacao = codigoIdentificacao;
        this.nome = nome;
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

    public static ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public static void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        Usuario.emprestimos = emprestimos;
    }

    static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    public void addReserva(Livro livro, String data) {
        this.reservas.add(new Reserva(data, livro, this));

    }

}
