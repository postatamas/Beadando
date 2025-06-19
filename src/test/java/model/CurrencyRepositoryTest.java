package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyRepositoryTest {

    @Test
    void testLoadCurrencies_shouldReturnNonEmptyList() {
        CurrencyRepository repo = new CurrencyRepository();
        List<Currency> currencies = repo.loadCurrencies();

        assertNotNull(currencies, "A valutalista nem lehet null");
        assertFalse(currencies.isEmpty(), "A valutalista nem lehet üres");

        // Ellenőrizés, hogy tartalmazza az USD-t
        boolean containsUSD = currencies.stream()
                .anyMatch(c -> "USD".equals(c.getCode()));
        assertTrue(containsUSD, "Az USD valuta hiányzik");
    }
}
