package Notificacao;

import Livro.Livro;

import java.util.ArrayList;
import java.util.List;

public class Consulta implements Notificacao{

    private final ArrayList<Observer> observers;

    Livro livro;

    public Consulta(Livro livro) {
        this.observers = new ArrayList<Observer>();
        this.livro = livro;
    }

    @Override
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerOberserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers() {
        //this.livro; TODO
        System.out.println("Observers -> ");
        observers.forEach(observer -> observer.update(livro));
    }
}
