import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(int bestellnr, Produkt[] produkte, Zustand zustand) {
        for (Observer observer : observers) {
            observer.update(bestellnr, produkte, zustand);
        }
    }
}
