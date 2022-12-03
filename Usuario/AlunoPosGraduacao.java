package Usuario;

import ReservarStrategy.ReservaAlunoPosGraduacao;

public class AlunoPosGraduacao extends Usuario {

    public static int tempoDeEmprestimoDias = 4;
    public static int limiteEmprestimoAberto = 4;

    public AlunoPosGraduacao(String codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
        this.reservaStrategy = new ReservaAlunoPosGraduacao();

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

}
