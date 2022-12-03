package EmprestimoStrategy;

import Emprestimo.Emprestimo;
import Livro.Livro;
import Usuario.AlunoGraduacao;
import Usuario.Usuario;

public class EmprestimoAlunoGraduacao implements EmprestimoStrategy {

    @Override
    public void emprestar(Usuario usuario, Livro livro) {

        // TODO Auto-generated method stub
        Boolean regra1 = livro.getExemplares().size() > 0;
        if (!regra1) {
            System.out.println("erro na regra 1");
            return;
        }

        System.out.println("regra1: " + regra1);

        Boolean regra2 = !usuario.getDevedor();
        System.out.println("regra2: " + regra2);

        Boolean regra3 = !(usuario.getEmprestimos().size() > AlunoGraduacao.limiteEmprestimoAberto);
        System.out.println("regra3: " + regra3);

        Boolean regra4 = ((livro.getReservas().size() < livro.getExemplares().size()
                && livro.EncontrarReservaPorIdUsuario(usuario.getCodigoIdentificacao()) != null));
        System.out.println("regra4: " + regra4);

        System.out.println("2 - Usuario não é devedor: " + !usuario.getDevedor());
        System.out.println(
                "3 - Regras obedecidas: " + !(usuario.getEmprestimos().size() > AlunoGraduacao.limiteEmprestimoAberto));
        System.out.println("4 - Usuario não é devedor: " + !usuario.getDevedor());

        if (regra1 && !usuario.getDevedor()
                && !(usuario.getEmprestimos().size() > AlunoGraduacao.limiteEmprestimoAberto)
                && (livro.getReservas().size() < livro.getExemplares().size())
                && (livro.getReservas().size() >= livro.getExemplares().size()
                        && livro.EncontrarReservaPorIdUsuario(usuario.getCodigoIdentificacao()) != null)
                && usuario.EncontrarEmprestimoPorIdLivro(livro.getCodigoIdentificacao()) == null) {

            usuario.getEmprestimos().add(new Emprestimo(usuario, livro));
            System.out.println("emprestimo realizado");

        } else {
            System.out.println("emprestimo nao realizado");

        }

    }

}
