package LivroState;

import Livro.Exemplar;

public class Disponivel extends EstadoExemplar {

    public Disponivel(Exemplar exemplar) {
        super(exemplar);
        this.status = true;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onDisponivel() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onEmprestado() {
        // TODO Auto-generated method stub
        exemplar.setEstado(new Emprestado(exemplar));

    }

}
