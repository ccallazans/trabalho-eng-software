package LivroState;

import Livro.Livro;

public class Disponivel extends EstadoLivro {

    public Disponivel(Livro livro) {
        super(livro);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onDisponivel() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onEmprestado() {
        // TODO Auto-generated method stub
        livro.setEstado(new Emprestado(livro));

    }

}
