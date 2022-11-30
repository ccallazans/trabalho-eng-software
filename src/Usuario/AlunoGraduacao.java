package Usuario;

public class AlunoGraduacao extends Usuario {

    int tempoEmprestimo = 3;

    public AlunoGraduacao(int codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
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
