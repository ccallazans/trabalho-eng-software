package Usuario;

import Livro.Livro;

public class Professor extends Usuario {

    public Professor(int codigoIdentificacao, String nome) {
        super(codigoIdentificacao, nome);
    }


    @Override
    public void update(Livro livro) {
        System.out.println("Professor " + this.getNome() + " foi notificado do livro " + livro.getTitulo());
    }
}
