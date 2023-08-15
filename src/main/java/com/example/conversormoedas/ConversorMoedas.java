package com.example.conversormoedas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class ConversorMoedas extends Application {
    private ComboBox<String> fromCurrencyComboBox;
    private ComboBox<String> toCurrencyComboBox;
    private TextField inputTextField;
    private Label resultLabel;

    private final double[] exchangeRates = {1.0, 5.38, 6.37, 7.49, 0.066, 0.0076}; // Exchange rates for: BRL, USD, Euro, GBP, ARS, CLP

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        fromCurrencyComboBox = new ComboBox<>();
        toCurrencyComboBox = new ComboBox<>();
        inputTextField = new TextField();
        resultLabel = new Label();

        String[] currencies = {"Reais (BRL)", "Dólar (USD)", "Euro (EUR)", "Libras Esterlinas (GBP)", "Peso Argentino (ARS)", "Peso Chileno (CLP)"};
        fromCurrencyComboBox.getItems().addAll(currencies);
        toCurrencyComboBox.getItems().addAll(currencies);

        Button convertButton = new Button("Converter");
        convertButton.setOnAction(event -> convertCurrency());

        gridPane.add(new Label("De:"), 0, 0);
        gridPane.add(fromCurrencyComboBox, 1, 0);
        gridPane.add(new Label("Para:"), 0, 1);
        gridPane.add(toCurrencyComboBox, 1, 1);
        gridPane.add(new Label("Valor:"), 0, 2);
        gridPane.add(inputTextField, 1, 2);
        gridPane.add(new Label("Resultado:"), 0, 3);
        gridPane.add(resultLabel, 1, 3);
        gridPane.add(convertButton, 1, 4);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convertCurrency() {
        int fromIndex = fromCurrencyComboBox.getSelectionModel().getSelectedIndex();
        int toIndex = toCurrencyComboBox.getSelectionModel().getSelectedIndex();
        double inputValue = Double.parseDouble(inputTextField.getText());

        double convertedValue = inputValue * exchangeRates[toIndex] / exchangeRates[fromIndex];
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        resultLabel.setText(decimalFormat.format(convertedValue));
    }
}

