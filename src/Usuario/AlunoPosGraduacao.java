package Usuario;

public class AlunoPosGraduacao extends Usuario {

    int tempoEmprestimo = 4;

    public AlunoPosGraduacao(int codigoIdentificacao, String nome) {
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
