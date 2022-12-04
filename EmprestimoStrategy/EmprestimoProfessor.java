package EmprestimoStrategy;

import Emprestimo.Emprestimo;
import Livro.Livro;
import Livro.Exemplar;
import LivroState.Emprestado;
import Usuario.AlunoGraduacao;
import Usuario.Usuario;

import java.time.LocalDate;

public class EmprestimoProfessor implements EmprestimoStrategy {

    @Override
    public void emprestar(Usuario usuario, Livro livro) {
        String mensagem = null;

        // TODO Auto-generated method stub
//        Boolean regra1 = livro.getExemplares().size() > 0;
        Boolean regra1 = livro.isAvailableExemplar(livro.getCodigoIdentificacao());
        if (!regra1) {
            mensagem = (mensagem != null) ? mensagem : "Insucesso! Não há disponibilidade de exemplades desse livro!";
        }

        Boolean regra2 = !usuario.getDevedor();
        if (!regra2) {
            mensagem = (mensagem != null) ? mensagem : "Insucesso! Usuário é devedor!";
        }

        if (regra1 && regra2) {

            // Caso exista reseva, remover
            usuario.removeReservaByIdLivro(livro.getCodigoIdentificacao());
            livro.removeReservaByIdUsuario(usuario.getCodigoIdentificacao());

            // Criar novo emprestimo com data de devolucao
            LocalDate dataDevolver = LocalDate.now().plusDays(usuario.getTempoDeEmprestimoDias());
            Emprestimo novoEmprestimo = new Emprestimo(usuario, livro, dataDevolver);

            // Atualizar informação do exemplar para emprestado e atualizar ultimoEmprestimo
            Exemplar selectExemplar = livro.getAvaiableExemplarByLivroId(livro.getCodigoIdentificacao());
            selectExemplar.setEstado(new Emprestado(selectExemplar));
            selectExemplar.setUltimoEmprestimo(novoEmprestimo);

            // Adicionar emprestimo na lista de emprestimos. (AllEmprestimos registra todos os emprestimos atual e antigo)
            usuario.getEmprestimos().add(novoEmprestimo);
            usuario.getAllEmprestimos().add(novoEmprestimo);
            mensagem = "Sucesso!";
        }

        System.out.println("Usuário: " + usuario.getNome() +
                "\nTítulo: " + livro.getTitulo() +
                "\nMensagem: " + mensagem);

    }

}
