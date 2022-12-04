package EmprestimoStrategy;

import Emprestimo.Emprestimo;
import Livro.Livro;
import Livro.Exemplar;
import LivroState.Emprestado;
import Usuario.AlunoGraduacao;
import Usuario.Usuario;

import java.time.LocalDate;
import java.util.Date;

public class EmprestimoAlunoGraduacao implements EmprestimoStrategy {

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

        Boolean regra3 = !(usuario.getEmprestimos().size() >= AlunoGraduacao.limiteEmprestimoAberto);
        if (!regra3) {
            mensagem = (mensagem != null) ? mensagem : "Insucesso! Usuário ultrapassou o limite de empréstimos!";
        }


//        Boolean regra4 = ((livro.getReservas().size() < livro.getExemplares().size() ? true
//                : livro.EncontrarReservaPorIdUsuario(usuario.getCodigoIdentificacao()) != null));
        Boolean regra4 = ((livro.getReservas().size() < livro.countAvailableExemplar(livro.getCodigoIdentificacao())) ? true
                : livro.EncontrarReservaPorIdUsuario(usuario.getCodigoIdentificacao()) != null);
        if (!regra4) {
            mensagem = (mensagem != null) ? mensagem : "Insucesso! Quantidade de reservas maior do que a quantidade de exmplares disponíveis!";
        }

//        Boolean regra5 = usuario.EncontrarEmprestimoPorIdLivro(livro.getCodigoIdentificacao()) == null;
        Boolean regra5 = (livro.getReservas().size() >= livro.countAvailableExemplar(livro.getCodigoIdentificacao())) ? livro.EncontrarReservaPorIdUsuario(usuario.getCodigoIdentificacao()) != null : true;
        if (!regra5) {
            mensagem = (mensagem != null) ? mensagem : "Insucesso! Qaaaaaaaaaaaa!";
        }

        Boolean regra6 = !(usuario.hasEmprestimoPorIdLivro(livro.getCodigoIdentificacao()));
        if (!regra6) {
            mensagem = (mensagem != null) ? mensagem : "Insucesso! Usuário já possui um empréstimo desse livro";
        }

        if (regra1 && regra2 && regra3 && regra4 && regra5 && regra6) {

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
