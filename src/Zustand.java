public enum Zustand {
    NEU("Neu", "Die Bestellung ist eingelangt, wird aber noch nicht bearbeitet."),
    IN_BEARBEITUNG("In Bearbeitung","Ein:e Mitarbeiter:in hat die Bearbeitung der Bestellung begonnen."),
    BEREIT("Bereit", "Die Bestellung kann von dem/der Kund:in abgeholt werden."),
    ABGEHOLT("Abgeholt","Die Bestellung kann aus den Systemen entfernt werden.");

    private final String name;
    private final String beschreibung;

    // Konstruktor
    Zustand(String name, String beschreibung) {
        this.name = name;
        this.beschreibung = beschreibung;
    }

    // Getter-Methode
    public String getName() {
        return name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
}
