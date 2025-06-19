package model;

public class CurrencyConverter {

    public double convert(double amount, Currency from, Currency to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("A valuták nem lehetnek null értékűek.");
        }

        if (from.getRate() <= 0 || to.getRate() <= 0) {
            throw new IllegalArgumentException("A valuták árfolyama pozitív szám kell legyen.");
        }

        return amount * (to.getRate() / from.getRate());
    }
}