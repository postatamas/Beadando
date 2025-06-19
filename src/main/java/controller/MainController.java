package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Currency;
import model.CurrencyConverter;
import model.CurrencyRepository;

import java.util.List;

public class MainController {

    @FXML
    private ComboBox<Currency> fromCurrencyComboBox;

    @FXML
    private ComboBox<Currency> toCurrencyComboBox;

    @FXML
    private TextField amountTextField;

    @FXML
    private Button convertButton;

    @FXML
    private Label resultLabel;

    private List<Currency> currencyList;
    private final CurrencyRepository repository = new CurrencyRepository();
    private final CurrencyConverter converter = new CurrencyConverter();

    @FXML
    public void initialize() {
        currencyList = repository.loadCurrencies();

        fromCurrencyComboBox.getItems().addAll(currencyList);
        toCurrencyComboBox.getItems().addAll(currencyList);

        // alapértelmezett kiválasztás
        if (!currencyList.isEmpty()) {
            fromCurrencyComboBox.getSelectionModel().select(0);
            toCurrencyComboBox.getSelectionModel().select(1);
        }

        convertButton.setOnAction(e -> convert());
    }

    private void convert() {
        try {
            double amount = Double.parseDouble(amountTextField.getText());

            Currency from = fromCurrencyComboBox.getValue();
            Currency to = toCurrencyComboBox.getValue();

            if (from == null || to == null) {
                resultLabel.setText("Válassz valutákat!");
                return;
            }

            double result = converter.convert(amount, from, to);
            resultLabel.setText(String.format("Eredmény: %.2f %s", result, to.getCode()));

        } catch (NumberFormatException e) {
            resultLabel.setText("Hibás összeg!");
        } catch (Exception e) {
            resultLabel.setText("Hiba: " + e.getMessage());
        }
    }
}
