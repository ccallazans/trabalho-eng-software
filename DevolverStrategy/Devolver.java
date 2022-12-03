package DevolverStrategy;

import Emprestimo.Emprestimo;
import Livro.Livro;
import Livro.Exemplar;
import LivroState.Disponivel;
import Usuario.Usuario;

public class Devolver implements DevolverStrategy {
    @Override
    public void devolver(Usuario usuario, Livro emprestimoLivro) {

        Boolean regra1 = usuario.hasEmprestimoPorIdLivro(emprestimoLivro.getCodigoIdentificacao());
        String mensagem;
        if (regra1) {
            mensagem = "Sucesso! Devolução realizada";

            // Encontrar o emprestimo e remover da lista de emprestimo
            Emprestimo devEmprestimo = usuario.EncontrarEmprestimoPorIdLivro(emprestimoLivro.getCodigoIdentificacao());
            usuario.getEmprestimos().remove(devEmprestimo);

            // Encontrar o exemplar emprestado e deixa-lo disponivel novamente
            Exemplar devExemplar = emprestimoLivro.getExemplarByIdUsuarioIdLivro(usuario.getCodigoIdentificacao(), emprestimoLivro.getCodigoIdentificacao());
            devExemplar.setEstado(new Disponivel(devExemplar));
            devExemplar.setUltimoEmprestimo(null);

        } else {
            mensagem = "Insucesso! Não existe empréstimo do livro " + emprestimoLivro.getCodigoIdentificacao() + " para o usuário " + usuario.getCodigoIdentificacao() + ".";
        }

        System.out.println("Usuário: " + usuario.getNome() +
                "\nTítulo: " + emprestimoLivro.getTitulo() +
                "\nMensagem: " + mensagem);
    }
}
