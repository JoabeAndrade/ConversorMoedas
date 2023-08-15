module com.example.conversormoedas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.conversormoedas to javafx.fxml;
    exports com.example.conversormoedas;
}