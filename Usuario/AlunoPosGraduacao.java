package Usuario;

import EmprestimoStrategy.EmprestimoAlunoPosGraduacao;
import Livro.Livro;
import ReservarStrategy.ReservaAlunoPosGraduacao;

public class AlunoPosGraduacao extends Usuario {

    public static int tempoDeEmprestimoDias = 4;
    public static int limiteEmprestimoAberto = 4;

    public AlunoPosGraduacao(String codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
        this.reservaStrategy = new ReservaAlunoPosGraduacao();
        this.emprestimoStrategy = new EmprestimoAlunoPosGraduacao();

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
