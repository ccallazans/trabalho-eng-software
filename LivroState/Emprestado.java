package LivroState;

import Livro.Livro;

public class Emprestado extends EstadoLivro {

    public Emprestado(Livro livro) {
        super(livro);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onDisponivel() {
        // TODO Auto-generated method stub
        livro.setEstado(new Disponivel(livro));

    }

    @Override
    public void onEmprestado() {
        // TODO Auto-generated method stub

    }

}
