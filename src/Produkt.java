public enum Produkt {
    BURGER("Veggie Burger", 8.50),
    FALAFEL("Falafel with Hummus", 4.20),
    PIZZA("Pizza Funghi", 9.70),
    BURRITO("Black Bean Burrito", 6.90),
    TACO("Taco with Guacamole", 5.80),
    SUSHI("Sushi Set", 8.20),
    TEA("Jasmin Tea", 3.10),
    ESPRESSO("Neapolitano Strong Roast Espresso", 2.70),
    WATER("Klosterneuburger Spring Water", 0.50),
    LEMONSODA("Sicilian Lemon Mineral", 1.80);

    // Attributes
    private final String name;
    private final double price;

    // Constructor
    Produkt(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
