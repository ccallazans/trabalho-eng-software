package LivroState;

import Livro.Exemplar;

public class Emprestado extends EstadoExemplar {

    public Emprestado(Exemplar exemplar) {
        super(exemplar);
        this.status = false;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onDisponivel() {
        // TODO Auto-generated method stub
        exemplar.setEstado(new Disponivel(exemplar));

    }

    @Override
    public void onEmprestado() {
        // TODO Auto-generated method stub

    }

}
