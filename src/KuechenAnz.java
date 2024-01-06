import java.util.ArrayList;
import java.util.stream.Collectors;

public class KuechenAnz implements Observer {
    public ArrayList<Bestellung> aktuelleBestellungen;

    private BestellungsManagement bestellungsManager;


    public KuechenAnz(BestellungsManagement m) {
        this.aktuelleBestellungen = new ArrayList<>();
        this.bestellungsManager = m;
    }

    public String display() {
        String b = "***Küchen-Anzeige***\n";
        for(int i = 0; i < aktuelleBestellungen.size(); i++) {
            if (aktuelleBestellungen.get(i).getZustand() == Zustand.NEU) {

                // order number
                b += aktuelleBestellungen.get(i).bestellnr + " " +
                        aktuelleBestellungen.get(i).getZustand().getName() + " ";

                // products
                String prod = "";
                for (int j = 0; j < aktuelleBestellungen.get(i).produkte.length; j++) {
                    prod += aktuelleBestellungen.get(i).produkte[j].getName();
                    if (j+1 < aktuelleBestellungen.get(i).produkte.length) {
                        prod += ", ";
                    }
                }
                b += "[" + prod + "]\n";
            }
        }
        return b;
    }

    @Override
    public void update(int nr, Produkt[] produkte, Zustand zustand) {
        boolean bestellungGefunden = false;
        for (Bestellung bestellung : aktuelleBestellungen) {
            if (bestellung.getBestellnr() == nr) {
                bestellung.setProdukte(produkte);
                bestellung.setZustand(zustand);
                bestellungGefunden = true;
                break;
            }
        }

        if (!bestellungGefunden && zustand == Zustand.NEU) {
            Bestellung neueBestellung = new Bestellung(nr, produkte, zustand);
            aktuelleBestellungen.add(neueBestellung);
        }

        // Sortiere die Bestellungen chronologisch
        aktuelleBestellungen = (ArrayList<Bestellung>) aktuelleBestellungen.stream()
                .sorted((b1, b2) -> Integer.compare(b1.getBestellnr(), b2.getBestellnr()))
                .collect(Collectors.toList());

        display();

    }

    private int findOrderIndexByNumber(int orderNumber) {
        for (int i = 0; i < aktuelleBestellungen.size(); i++) {
            if (aktuelleBestellungen.get(i).getBestellnr() == orderNumber) {
                return i; // Return the index of the found order
            }
        }
        return -1; // Return -1 if the order is not found
    }

    // Check if the order exists in the list and then set its status to IN_BEARBEITUNG
    public void bestellungBerbeiten(int nr) {
        int id = findOrderIndexByNumber(nr);

        if (aktuelleBestellungen.get(id) != null) {
            bestellungsManager.updateBestellStatus(nr, Zustand.IN_BEARBEITUNG);
        }
    }

    // Marks an order as BEREIT and updates its status accordingly.
    public void bestellungBereit(int nr) {
        int id = findOrderIndexByNumber(nr);

        if (aktuelleBestellungen.get(id) != null) {
            bestellungsManager.updateBestellStatus(nr, Zustand.BEREIT);
        }
    }
}
