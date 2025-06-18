package com.fxjava.javafx_lab;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.*;

public class Lab4 extends Application {
    @Override
    public void start(Stage stage) {
        TextField Txt1, Txt2, Txt3, plus, equal;
        TextField[] Text;

        Label Num1 = new Label("Num1");
        Label Num2 = new Label("Num2");
        plus = new TextField("+");
        equal = new TextField("=");
        Txt1 = new TextField();
        Txt2 = new TextField();
        Txt3 = new TextField();
        Text = new TextField[]{Txt1, Txt2, Txt3, plus, equal};
        for (TextField txt : Text) {
            txt.setMinSize(100, 100);
            txt.setMaxSize(100, 100);
            txt.setFont(new Font(20));
            if (txt == equal || txt == plus) {
                txt.setMinSize(50, 50);
                txt.setMaxSize(50, 50);
                txt.setEditable(false);
            }
        }

        plus.setMinSize(50, 50);
        equal.setMinSize(50, 50);
        Button button = new Button("CALCULATE");

        button.setOnAction(e -> {
            int num1, num2, sum;
            try {
                num1 = Integer.parseInt(Txt1.getText());  // returns int 123
                num2 = Integer.parseInt(Txt2.getText());
                sum = num1 + num2;
                Txt3.setText(String.valueOf(sum));
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("WARNING");
                alert.setHeaderText("PLEASE NO STRING"); // optional, can be a message title
                alert.setContentText("RE-TRY");
                alert.showAndWait();
            }
        });
        HBox hb1 = new HBox(10);
        hb1.getChildren().addAll(Num1, Txt1, plus, Num2, Txt2, equal);
        HBox.setMargin(plus, new Insets(20));
        HBox.setMargin(equal, new Insets(20));
        hb1.getChildren().addAll(Txt3);
        VBox vb = new VBox(10);
        vb.getChildren().addAll(hb1, button);
        VBox.setMargin(button, new Insets(100, 0, 0, 350));


        Scene scene = new Scene(vb, 1000, 800);
        stage.setTitle("Basic JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] argument) {

        launch(argument);

    }


}

//
////Wap to show example of GeidPane
//package com.fxjava.javafx_lab;
//
//import javafx.application.*;
//import javafx.scene.*;
//import javafx.scene.control.Button;
//import javafx.scene.layout.*;
//import javafx.stage.*;
//
//public class Lab4 extends Application {
//    @Override
//    public void start(Stage stage) {
//        GridPane gp = new GridPane();
//        Button b1 = new Button("B1");
//        Button b2 = new Button("B2");
//        Button b3 = new Button("B3");
//        Button b4 = new Button("B4");
//        gp.add(b1,0,0);
//        gp.add(b2,0,1);
//        gp.add(b3,1,0);
//        gp.add(b4,1,1);
//
//        Scene sc = new Scene(gp, 400, 400);
//        stage.setScene(sc);
//        stage.setTitle("Grid Layout");
//        stage.show();
//    }
//    public static void main(String[] argument) {
//  launch(argument);
//
//    }
//}