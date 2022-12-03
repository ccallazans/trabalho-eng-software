package Usuario;

import EmprestimoStrategy.EmprestimoAlunoGraduacao;
import Livro.Livro;
import ReservarStrategy.ReservaAlunoGraduacao;

public class AlunoGraduacao extends Usuario {

    public static int tempoDeEmprestimoDias = 3;
    public static int limiteEmprestimoAberto = 3;

    public AlunoGraduacao(String codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
        this.reservaStrategy = new ReservaAlunoGraduacao();
        this.emprestimoStrategy = new EmprestimoAlunoGraduacao();

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void reservar(Livro livro, String data) {
        this.reservaStrategy.reservar(this, livro, data);
    }

}
