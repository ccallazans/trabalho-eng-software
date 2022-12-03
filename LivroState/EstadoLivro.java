package LivroState;

import Livro.Livro;

public abstract class EstadoLivro {

    protected Livro livro;

    public EstadoLivro(Livro livro) {
        this.livro = livro;
    }

    public abstract void onDisponivel();

    public abstract void onEmprestado();

}
