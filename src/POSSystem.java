public class POSSystem {
    private BestellungsManagement bestellungsManagement;

    public POSSystem(BestellungsManagement bestellungsManagement) {
        this.bestellungsManagement = bestellungsManagement;
    }

    public void bestellen(Bestellung b) {
        bestellungsManagement.bestellen(b);
    }
}
