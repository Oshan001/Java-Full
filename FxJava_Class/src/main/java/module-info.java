module com.fxjava.fxjava_class {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fxjava.fxjava_class to javafx.fxml;
    exports com.fxjava.fxjava_class;
}