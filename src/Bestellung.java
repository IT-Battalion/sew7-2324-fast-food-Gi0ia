public class Bestellung {
    int bestellnr;
    Produkt[] produkte;
    Zustand zustand;

    public Bestellung() {
        this.bestellnr = 0;
        this.produkte[0] = Produkt.WATER;
        this.zustand = Zustand.NEU;
    }

    public Bestellung(int nr, Produkt[] p, Zustand z) {
        this.bestellnr = nr;
        this.produkte = p;
        this.zustand = z;
    }


    public int getBestellnr() {
        return bestellnr;
    }

    public void setBestellnr(int bestellnr) {
        this.bestellnr = bestellnr;
    }

    public Produkt[] getProdukte() {
        return produkte;
    }

    public void setProdukte(Produkt[] produkt) {
        this.produkte = produkt;
    }

    public Zustand getZustand() {
        return zustand;
    }

    public void setZustand(Zustand zustand) {
        this.zustand = zustand;
    }
}
