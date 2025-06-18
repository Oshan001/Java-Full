//package com.fxjava.fxjava_class;
//
//import javafx.application.*;
//import javafx.scene.*;
//import javafx.scene.control.*;
//import javafx.scene.layout.HBox;
//import javafx.stage.*;
//
//import java.io.IOException;
//
//public class ClassActivity extends Application {
//    @Override
//    public void start(Stage stage) {
//        RadioButton  jv= new RadioButton("Java");
//        RadioButton net = new RadioButton("Net");
//        ToggleGroup tg =new ToggleGroup();
//        jv.setToggleGroup(tg); net.setToggleGroup(tg);
//        CheckBox extra = new CheckBox();
//        ComboBox cb = new ComboBox();
//         cb.getItems().addAll("Morning","Day");
//
//        TextArea ta = new TextArea();
//        ta.setPromptText("Details");
//        Button ok = new Button("OK");
//        HBox hb  = new HBox(10,jv,net,extra,cb,ta,ok);
//        ok .setOnAction(e-> {
//                ta.setText("");
//                String cource = "java";
//                if(net.isSelected()) cource = "Net";
//                ta.appendText("Cource :"+cource);
//            if(extra.isSelected()) ta.appendText("\n Extra Selected");
//            ta.appendText("\n Time: "+ cb.getValue());
//        });
//            Scene sc = new Scene(hb,400,400);
//            stage.setScene(sc);
//            stage.setTitle("Fx component");
//            stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

//
//
////Layout in Javafx
////--define the arrangement of Component
////Vbox =vertical alignment
////Hbox = Horizontal  alignment
////BroderPanel = lays in 5 sided(left,right,top,bottom,center);tg.setTop(jb);
////GridPane = Array is grid grid.add(jb,11)
////StackPane = arrays on top of each other
////pane  =custom position ;setLayout(10);
////Tilepane = Array in tiles
////flowPane =   Array in a Flow (left to Right or up to down);new FlowPane(orientation.VERTICAL || HORIZONTAL)
////Anchorpane= Allows to anchor child nodes to its edges or center
//
//package com.fxjava.fxjava_class;
//
//import javafx.application.*;
//import javafx.scene.*;
//import javafx.scene.control.*;
//import javafx.scene.layout.Border;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.stage.*;
//
//
//
//public class ClassActivity extends Application {
//    @Override
//    public void start(Stage stage) {
//     BorderPane  bp  =new BorderPane();
//       bp.setTop(new Button("top"));
//       bp.setTop(new TextField());
//
//            Scene sc = new Scene(bp,400,400);
//            stage.setScene(sc);
//            stage.setTitle("Fx component");
//            stage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}



//Networking in java
package com.fxjava.fxjava_class;

