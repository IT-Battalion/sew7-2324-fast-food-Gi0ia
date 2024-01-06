public interface Observer {
    void update(int bestellnr, Produkt[] produkte, Zustand zustand);
}
