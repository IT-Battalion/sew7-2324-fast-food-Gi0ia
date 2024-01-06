import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KassaTerminalTest {
    private KassaTerminal kassaTerminal;
    private BestellungsManagement management;

    @BeforeEach
    void setUp() {
        management = new BestellungsManagement();
        kassaTerminal = new KassaTerminal(management);
    }

    @Test
    void update() {
        Produkt[] p = new Produkt[]{Produkt.PIZZA, Produkt.LEMONSODA};
        kassaTerminal.update(1, p, Zustand.NEU);

        assertTrue(kassaTerminal.aktuelleBestellungen.stream().anyMatch(b -> b.getBestellnr() == 1 && b.getZustand() == Zustand.NEU));
    }

    @Test
    void display() {
        Produkt[] p = new Produkt[]{Produkt.PIZZA, Produkt.LEMONSODA};
        kassaTerminal.aktuelleBestellungen.add(new Bestellung(1, p, Zustand.ABGEHOLT));

        String expectedDisplay = "***Kassa-Terminal***\n1 Abgeholt [Pizza Funghi, Sicilian Lemon Mineral] => 11.5 €\n";
        assertEquals(expectedDisplay, kassaTerminal.display());
    }

    /*@Test
    void bestellungAbholen() {
        Produkt[] p = new Produkt[]{Produkt.PIZZA, Produkt.LEMONSODA};
        kassaTerminal.aktuelleBestellungen.add(new Bestellung(1, p, Zustand.BEREIT));
        kassaTerminal.bestellungAbholen(1);

        assertEquals(Zustand.ABGEHOLT, kassaTerminal.aktuelleBestellungen.get(0).getZustand());
    }

    // Mock-Klasse für BestellungsManagement
    private static class BestellungsManagementMock {
        public void updateBestellStatus(int nr, Zustand zustand) {
            // Hier könnte die Implementierung erfolgen, falls erforderlich
        }
    }*/
}