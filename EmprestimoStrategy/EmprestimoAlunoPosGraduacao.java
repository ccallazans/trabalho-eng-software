package EmprestimoStrategy;

import Emprestimo.Emprestimo;
import Livro.Livro;
import Usuario.AlunoGraduacao;
import Usuario.Usuario;

public class EmprestimoAlunoPosGraduacao implements EmprestimoStrategy {

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

        Boolean regra4 = ((livro.getReservas().size() < livro.getExemplares().size() ? true
                : livro.EncontrarReservaPorIdUsuario(usuario.getCodigoIdentificacao()) != null));
        System.out.println("regra4: " + regra4);

        Boolean regra5 = usuario.EncontrarEmprestimoPorIdLivro(livro.getCodigoIdentificacao()) == null;
        System.out.println("Regra 5: " + regra5);

        if (regra1 && regra2 && regra3 && regra4 && regra5) {
            usuario.getEmprestimos().add(new Emprestimo(usuario, livro));
            System.out.println("emprestimo realizado");

        } else {
            System.out.println("emprestimo nao realizado");

        }

    }

}
