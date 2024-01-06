import java.util.ArrayList;
import java.util.stream.Collectors;

public class KassaTerminal implements Observer {
    public ArrayList<Bestellung> aktuelleBestellungen;

    private BestellungsManagement bestellungsManager;

    public KassaTerminal(BestellungsManagement m) {
        this.aktuelleBestellungen = new ArrayList<>();
        this.bestellungsManager = m;
    }

    @Override
    public void update(int bestellnr, Produkt[] produkte, Zustand zustand) {
        boolean bestellungGefunden = false;
        for (Bestellung bestellung : aktuelleBestellungen) {
            if (bestellung.getBestellnr() == bestellnr) {
                bestellung.setProdukte(produkte);
                bestellung.setZustand(zustand);
                bestellungGefunden = true;
                break;
            }
        }

        if (!bestellungGefunden && zustand == Zustand.NEU) {
            Bestellung neueBestellung = new Bestellung(bestellnr, produkte, zustand);
            aktuelleBestellungen.add(neueBestellung);
        }

        // Sortiere die Bestellungen chronologisch
        aktuelleBestellungen = (ArrayList<Bestellung>) aktuelleBestellungen.stream()
                .sorted((b1, b2) -> Integer.compare(b1.getBestellnr(), b2.getBestellnr()))
                .collect(Collectors.toList());

    }

    public String display() {
        String b = "***Kassa-Terminal***\n";
        for(int i = 0; i < aktuelleBestellungen.size(); i++) {
            if (aktuelleBestellungen.get(i).getZustand() == Zustand.ABGEHOLT) {

                // order number
                b += aktuelleBestellungen.get(i).bestellnr + " " +
                        aktuelleBestellungen.get(i).getZustand().getName() + " ";

                // products
                String prod = "";
                float euro = 0;
                for (int j = 0; j < aktuelleBestellungen.get(i).produkte.length; j++) {
                    prod += aktuelleBestellungen.get(i).produkte[j].getName();
                    euro += aktuelleBestellungen.get(i).produkte[j].getPrice();
                    if (j+1 < aktuelleBestellungen.get(i).produkte.length) {
                        prod += ", ";
                    }
                }
                b += "[" + prod + "] => " + euro + " €\n";
            }
        }
        return b;
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
    public void bestellungAbholen(int nr) {
        int id = findOrderIndexByNumber(nr);

        if (aktuelleBestellungen.get(id) != null) {
            bestellungsManager.updateBestellStatus(nr, Zustand.ABGEHOLT);
        }
    }
}