package LivroState;

import Livro.Exemplar;

public abstract class EstadoExemplar {

    protected Exemplar exemplar;
    public boolean status;

    public EstadoExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public abstract void onDisponivel();

    public abstract void onEmprestado();

}
