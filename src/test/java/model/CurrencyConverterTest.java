package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    @Test
    void convert_shouldCalculateCorrectResult() {
        Currency eur = new Currency("EUR", "Euro", 0.93);
        Currency huf = new Currency("HUF", "Hungarian Forint", 365.0);

        CurrencyConverter converter = new CurrencyConverter();
        double result = converter.convert(10, eur, huf);

        // elvárt érték: 10 * (365 / 0.93) ≈ 3924.73
        assertEquals(3924.73, result, 0.1);
    }

    @Test
    void convert_shouldThrowIfCurrencyIsNull() {
        CurrencyConverter converter = new CurrencyConverter();

        assertThrows(IllegalArgumentException.class, () -> converter.convert(10, null, new Currency()));
        assertThrows(IllegalArgumentException.class, () -> converter.convert(10, new Currency(), null));
    }

    @Test
    void convert_shouldThrowIfRateIsZeroOrNegative() {
        Currency invalid = new Currency("X", "Invalid", 0);
        Currency valid = new Currency("Y", "Valid", 1.0);

        CurrencyConverter converter = new CurrencyConverter();
        assertThrows(IllegalArgumentException.class, () -> converter.convert(10, invalid, valid));
        assertThrows(IllegalArgumentException.class, () -> converter.convert(10, valid, invalid));
    }
}
