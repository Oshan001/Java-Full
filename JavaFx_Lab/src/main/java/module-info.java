module com.fxjava.javafx_lab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fxjava.javafx_lab to javafx.fxml;
    exports com.fxjava.javafx_lab;
}