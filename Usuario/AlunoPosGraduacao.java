package Usuario;

import DevolverStrategy.Devolver;
import EmprestimoStrategy.EmprestimoAlunoPosGraduacao;
import Livro.Livro;
import ReservarStrategy.ReservaAlunoPosGraduacao;

public class AlunoPosGraduacao extends Usuario {

    public static int limiteEmprestimoAberto = 4;

    public AlunoPosGraduacao(String codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
        this.reservaStrategy = new ReservaAlunoPosGraduacao();
        this.emprestimoStrategy = new EmprestimoAlunoPosGraduacao();
        this.devolverStrategy = new Devolver();
        this.tempoDeEmprestimoDias = 4;

    }

    @Override
    public void reservar(Livro livro, String data) {
        this.reservaStrategy.reservar(this, livro, data);
    }

}
