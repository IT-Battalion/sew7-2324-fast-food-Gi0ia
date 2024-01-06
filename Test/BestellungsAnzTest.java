import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class BestellungsAnzTest {

    @org.junit.jupiter.api.Test
    void display() {
        Produkt[] p = new Produkt[]{Produkt.BURRITO};
        BestellungsAnz bestellungsAnz = new BestellungsAnz();
        bestellungsAnz.aktuelleBestellungen.add(new Bestellung(1, p , Zustand.NEU));

        String erwartetesErgebnis = "***Bestellungs-Anzeige***\n1 Ausstehend\n";
        assertEquals(erwartetesErgebnis, bestellungsAnz.display());
    }

    @org.junit.jupiter.api.Test
    void update() {
        Produkt[] p = new Produkt[]{Produkt.BURRITO};
        BestellungsAnz bestellungsAnz = new BestellungsAnz();
        bestellungsAnz.update(1, p, Zustand.NEU);

        assertTrue(bestellungsAnz.aktuelleBestellungen.stream().anyMatch(b -> b.getBestellnr() == 1 && b.getZustand() == Zustand.NEU));
    }
}