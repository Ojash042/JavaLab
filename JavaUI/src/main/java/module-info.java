module com.example.javaui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaui to javafx.fxml;
    exports com.example.javaui;
}