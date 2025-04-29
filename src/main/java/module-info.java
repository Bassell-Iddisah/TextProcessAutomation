module com.example.textprocessautomation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.textprocessautomation to javafx.fxml;
    exports com.example.textprocessautomation;
    exports com.example.textprocessautomation.controller;
    opens com.example.textprocessautomation.controller to javafx.fxml;
}