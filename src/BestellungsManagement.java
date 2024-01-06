import java.util.ArrayList;

public class BestellungsManagement extends Subject {
    private ArrayList<Bestellung> bestellungen;
    private ArrayList<Observer> observers;

    public BestellungsManagement() {
        bestellungen = new ArrayList<>();
    }

    public ArrayList getBestellungen() {
        return this.bestellungen;
    }

    public void updateBestellStatus(int nr, Zustand z) {
        for(int i = 0; i < bestellungen.size(); i++) {
            if(bestellungen.get(i).bestellnr == nr) {
                bestellungen.get(i).setZustand(z);
                notifyObservers(bestellungen.get(i).getBestellnr(), bestellungen.get(i).getProdukte(), bestellungen.get(i).getZustand());
                break;
            }
        }
    }

    public void bestellen(Bestellung e) {
        this.bestellungen.add(e);
        notifyObservers(e.getBestellnr(), e.getProdukte(), e.getZustand());
    }

}
