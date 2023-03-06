package model;


public class Money {
    private String name;
    private double value;

    public Money(String name) {
        this.name = name;
        switch (name) {

            case "RON":
                value=1;
                break;
            case "USD":
                value=4.9850;
                break;
            case "GBP":
                value=5.745;
                break;
            case "EUR":
                value=4.985;
                break;
            case "CHF":
                value=5.055;
                break;
            case "SEK":
                value=0.465;
                break;
            case "CAD":
                value=3.8150;
                break;
            case "MDL":
                value=0.27;
                break;
            case "HUF":
                value=0.0124;
                break;
            case "CZK":
                value=0.21;
                break;
            case "PLN":
                value=1.075;
                break;
            default:
                value=1;
        }
    }


    public double getValue() {
        return value;
    }
}
