package Usuario;

public abstract class Usuario implements FazerEmprestimo, FazerReserva {
    public int codigoIdentificacao;
    String nome;

    int emprestimosAbertos = 0;

    public Usuario(int codigoIdentificacao, String nome) {
        this.codigoIdentificacao = codigoIdentificacao;
        this.nome = nome;
    }
}
