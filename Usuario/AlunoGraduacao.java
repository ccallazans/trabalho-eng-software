package Usuario;

import DevolverStrategy.Devolver;
import EmprestimoStrategy.EmprestimoAlunoGraduacao;
import Livro.Livro;
import ReservarStrategy.ReservaAlunoGraduacao;

public class AlunoGraduacao extends Usuario {

    public static int limiteEmprestimoAberto = 3;

    public AlunoGraduacao(String codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
        this.reservaStrategy = new ReservaAlunoGraduacao();
        this.emprestimoStrategy = new EmprestimoAlunoGraduacao();
        this.devolverStrategy = new Devolver();
        this.tempoDeEmprestimoDias = 3;
    }

    @Override
    public void reservar(Livro livro, String data) {
        this.reservaStrategy.reservar(this, livro, data);
    }

}
