import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KuechenAnzTest {
    private KuechenAnz kuechenAnz;
    private BestellungsManagement management;

    @BeforeEach
    void setUp() {
        management = new BestellungsManagement();
        kuechenAnz = new KuechenAnz(management);
    }

    @Test
    void display() {
        Produkt[] p = new Produkt[]{Produkt.PIZZA, Produkt.LEMONSODA};
        kuechenAnz.aktuelleBestellungen.add(new Bestellung(1, p, Zustand.NEU));

        String erwartetesErgebnis = "***Küchen-Anzeige***\n1 Neu [Pizza Funghi, Sicilian Lemon Mineral]\n";
        assertEquals(erwartetesErgebnis, kuechenAnz.display());
    }

    @Test
    void update() {
        Produkt[] p = new Produkt[]{Produkt.PIZZA, Produkt.LEMONSODA};
        kuechenAnz.update(1, p, Zustand.NEU);

        assertTrue(kuechenAnz.aktuelleBestellungen.stream().anyMatch(b -> b.getBestellnr() == 1 && b.getZustand() == Zustand.NEU));

    }

    /*
    @Test
    void bestellungBerbeiten() {
        Produkt[] p = new Produkt[]{Produkt.PIZZA, Produkt.LEMONSODA};
        kuechenAnz.aktuelleBestellungen.add(new Bestellung(1, p, Zustand.NEU));
        BestellungsManagement.bestellungBearbeiten(1);

        assertEquals(Zustand.IN_BEARBEITUNG, kuechenAnz.aktuelleBestellungen.get(0).getZustand());

    }

    @Test
    void bestellungBereit() {
        Produkt[] p = new Produkt[]{Produkt.PIZZA, Produkt.TEA};
        kuechenAnz.aktuelleBestellungen.add(new Bestellung(1, p, Zustand.NEU));
        BestellungsManagement.bestellungBearbeiten(1);

        assertEquals(Zustand.BEREIT, kuechenAnz.aktuelleBestellungen.get(0).getZustand());
    }

    // Mock-Klasse für BestellungsManagement
    public class BestellungsManagement {
        public ArrayList<Bestellung> aktuelleBestellungen = new ArrayList<>();

        public void updateBestellStatus(int nr, Zustand zustand) {
            for(Bestellung bestellung : aktuelleBestellungen) {
                if(bestellung.getBestellnr() == nr) {
                    bestellung.setZustand(zustand);
                    break;
                }
            }
        }
    }*/
}