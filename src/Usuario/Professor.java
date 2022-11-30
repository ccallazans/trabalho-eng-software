package Usuario;

public class Professor extends Usuario {

    int tempoEmprestimo = 7;

    public Professor(int codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
        tempoEmprestimo = 7;
    }

    @Override
    public void novoEmprestimo() {

    }

    @Override
    public void removerEmprestimo() {

    }

    @Override
    public void novaReserva() {

    }

    @Override
    public void removerReserva() {

    }
}
