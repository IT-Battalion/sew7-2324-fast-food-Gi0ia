public class Restaurant {
    public static void main(String[] args) {
        BestellungsManagement manager = new BestellungsManagement();
        POSSystem pos = new POSSystem(manager);

        BestellungsAnz bAnzeige = new BestellungsAnz();
        manager.attach(bAnzeige);

        KuechenAnz kAnzeige = new KuechenAnz(manager);
        manager.attach(kAnzeige);

        KassaTerminal kassa = new KassaTerminal(manager);
        manager.attach(kassa);




        // new Order
        Produkt[] p = new Produkt[]{Produkt.BURRITO, Produkt.SUSHI, Produkt.ESPRESSO};
        Bestellung b = new Bestellung(1001, p, Zustand.NEU);
        pos.bestellen(b);

        Produkt[] p2 = new Produkt[]{Produkt.PIZZA, Produkt.LEMONSODA};
        Bestellung b2 = new Bestellung(990, p2, Zustand.NEU);
        pos.bestellen(b2);

        Produkt[] p3 = new Produkt[]{Produkt.FALAFEL, Produkt.TACO, Produkt.TEA};
        Bestellung b3 = new Bestellung(7790, p3, Zustand.NEU);
        pos.bestellen(b3);

        Produkt[] p4 = new Produkt[]{Produkt.BURGER};
        Bestellung b4 = new Bestellung(505, p4, Zustand.NEU);
        pos.bestellen(b4);



        // updaten
        manager.updateBestellStatus(1001, Zustand.IN_BEARBEITUNG);

        // Küchen Bearbeitung
        kAnzeige.bestellungBerbeiten(505);
        kAnzeige.bestellungBereit(505);
        kassa.bestellungAbholen(1001);
        kassa.bestellungAbholen(7790);

        // anzeigen
        System.out.println(bAnzeige.display());
        System.out.println(kAnzeige.display());
        System.out.println(kassa.display());
    }
}
