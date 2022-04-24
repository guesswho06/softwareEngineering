package model.observerPattern;

public interface Observable {
    public void addObserverOffice(ObserverOffice observer);
    public void deleteObserverOffice(ObserverOffice observer);
    public void notifyObserverOffice(ObserverOffice observer);
}
