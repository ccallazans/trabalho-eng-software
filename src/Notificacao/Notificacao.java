package Notificacao;

public interface Notificacao {
    public void adicionarObserver(Observer observer);
    public void removerOberserver(Observer observer);

    public void notificarObservers();
}
