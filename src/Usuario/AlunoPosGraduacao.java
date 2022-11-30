package Usuario;

import Livro.Livro;

public class AlunoPosGraduacao extends Usuario {

    int qntEmprestimo = 0;
    int maxQntEmprestimo = 4;

    public AlunoPosGraduacao(int codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
    }


    @Override
    public void update(Livro livro) {

    }

    public boolean validarEmprestimo(int codigoLivro) {
        if (this.isDevedor()) {
            return false;
        }

        if (!(this.qntEmprestimo < maxQntEmprestimo)) {
            return false;
        }

        int qntExemplarLivro = this.biblioteca.getQuantidadeExemplarLivro(codigoLivro);
        int qntReservaLivro = this.biblioteca.getQuantidadeReservaLivro(codigoLivro);

        if (!this.biblioteca.isUsuarioLivroReserva(this.getCodigoIdentificacao(), codigoLivro)) {
            if (qntReservaLivro >= qntExemplarLivro) {
                return false;
            }
        }

        if (qntReservaLivro >= qntExemplarLivro) {

        }



        return false;
    }
}
