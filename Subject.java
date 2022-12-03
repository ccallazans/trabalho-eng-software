public interface Subject {

    public void registerObserver(Observer observer);

    public void removeOberserver(Observer observer);

    public void notifyObservers();
}
