import java.util.ArrayList;
import java.util.stream.Collectors;

public class BestellungsAnz implements Observer {
    public ArrayList<Bestellung> aktuelleBestellungen;

    public BestellungsAnz() {
        this.aktuelleBestellungen = new ArrayList<>();
    }

    // alle Bestellnummern, die Neu/In Bearbeitung/Bereit sind angezeigt
    // Kund:innen können den Unterschied zwischen Neu und In Bearbeitung nicht sehen
    // Bestellnummern chronologisch aufsteigend vergeben werden, sollen diese auch so sortiert dargestellt werden.

    public String display() {
        String b = "***Bestellungs-Anzeige***\n";
        for(int i = 0; i < aktuelleBestellungen.size(); i++) {
            if (aktuelleBestellungen.get(i).getZustand() != Zustand.ABGEHOLT) {

                // order number
                b += aktuelleBestellungen.get(i).bestellnr + " ";

                // order status
                if(aktuelleBestellungen.get(i).getZustand() == Zustand.BEREIT) {
                    b  += Zustand.BEREIT.getName() + "\n";
                }
                else {
                    b += "Ausstehend\n";
                }

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

        if (!bestellungGefunden) {
            Bestellung neueBestellung = new Bestellung(nr, produkte, zustand);
            aktuelleBestellungen.add(neueBestellung);
        }

        // Sortiere die Bestellungen chronologisch
        aktuelleBestellungen = (ArrayList<Bestellung>) aktuelleBestellungen.stream()
                .sorted((b1, b2) -> Integer.compare(b1.getBestellnr(), b2.getBestellnr()))
                .collect(Collectors.toList());

    }

}
