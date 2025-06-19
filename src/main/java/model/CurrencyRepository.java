package model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class CurrencyRepository {

    private static final String JSON_PATH = "/data/currencies.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Currency> loadCurrencies() {
        try (InputStream is = getClass().getResourceAsStream(JSON_PATH)) {
            if (is == null) {
                throw new RuntimeException("Nem található a currencies.json fájl: " + JSON_PATH);
            }
            return objectMapper.readValue(is, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Hiba történt a valuták betöltésekor: " + e.getMessage(), e);
        }
    }
}
