package Usuario;

import Livro.Livro;

public class AlunoGraduacao extends Usuario {

    public AlunoGraduacao(int codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
    }

    public void fazerEmprestimo(int codigoLivro) {
        if (this.isDevedor()) {
            System.out.println("Erro: Usuário é devedor");
        }
    }

    @Override
    public void update(Livro livro) {

    }
}
