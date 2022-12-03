package EmprestimoStrategy;

import Emprestimo.Emprestimo;
import Livro.Livro;
import Usuario.AlunoGraduacao;
import Usuario.Usuario;

public class EmprestimoAlunoPosGraduacao implements EmprestimoStrategy {

    @Override
    public void emprestar(Usuario usuario, Livro livro) {
        // TODO Auto-generated method stub
        Boolean temDisponibilidade = livro.getExemplares().size() > 0;

        if (temDisponibilidade && usuario.getDevedor()
                && usuario.getEmprestimos().size() > AlunoGraduacao.limiteEmprestimoAberto
                && livro.getReservas().size() < livro.getExemplares().size()
                && (livro.getExemplares().size() >= livro.getExemplares().size()
                        && livro.EncontrarReservaPorIdUsuario(usuario.getCodigoIdentificacao()) != null)
                && usuario.EncontrarEmprestimoPorIdLivro(livro.getCodigoIdentificacao()) == null) {

            usuario.getEmprestimos().add(new Emprestimo(usuario, livro));

        }

    }

}
