//
// // input User  and password and print in popup in swing
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//public class Lab3 {
//    public static class FrameDemo extends JFrame implements ActionListener {
//        JLabel UserL, PassL;
//        JTextField UserT;
//        JPasswordField PassT;
//        JButton Log;
//
//        //UI
//        FrameDemo(){
//            UserL= new JLabel("User");
//            PassL= new JLabel("Password");
//            UserT=new JTextField(20);
//            PassT = new JPasswordField(20);
//            Log =new JButton("Login");
//            setLayout(new GridLayout(3,2));
//            add(UserL); add(UserT);//User ________
//            add(PassL); add(PassT);//Password ______
//            add(Log);//login button
//            Log.addActionListener(this);
//            setSize(300,150);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            setVisible(true);
//        }
////        //UI interaction event Handeling
//        @Override
//        public void actionPerformed(ActionEvent e){
//         String User =UserT.getText();
//         String pass=new String(PassT.getPassword());
//         JOptionPane.showMessageDialog(this,"USER:"+User+"\n"+"Password:"+pass);
//        }
//
//    }
//
//    public static void main(String[] args) {
//        new FrameDemo();
//    }
//}


//
////WAP to creat frame with two text field and one button(next) when button
// //is clicked the the sum of two digit muat show thied text field
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.awt.Toolkit;
// public class Lab3 {
//     public static class FrameDemo extends JFrame implements ActionListener {
//         JLabel TFL1, TFL2,TFLR;
//         JTextField TFT1,TFT2;
//         JButton But;
//
//         //UI
//         FrameDemo(){
//             super("Sum Calculator");//title of popup
//             TFL1 =new JLabel("Input1:");
//             TFL2=new JLabel("Input2:");
//             TFT1=new JTextField(20);
//             TFT2=new JTextField(20);
//             But=new JButton("Next");
//             TFLR  = new JLabel("Result");
//             But.addActionListener(this);
//             // Change text colors
//             TFL1.setForeground(Color.MAGENTA);
//             TFL2.setForeground(Color.ORANGE);
//             TFLR.setForeground(Color.BLUE);
//             TFT1.setForeground(Color.RED);
//             TFT2.setForeground(Color.GREEN);
//
//             setLayout(new GridLayout(6,1));
//             add(TFL1); add(TFT1);
//             add(TFL2); add(TFT2);
//             add(But); add(TFLR);
//             setSize(200,200);
//             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             setVisible(true);
//         }
//         //        //UI interaction event Handeling
//         @Override
//         public void actionPerformed(ActionEvent e) {
//
//                 try {
//                     int num1 = Integer.parseInt(TFT1.getText());
//                     int num2 = Integer.parseInt(TFT2.getText());
//                     int sum = num1 + num2;
//                     TFLR.setText(String.valueOf(sum));
//                 } catch (NumberFormatException ex) {
//                     Toolkit.getDefaultToolkit().beep();
//                     JOptionPane.showMessageDialog(this, "Please enter valid numbers \n input Number not Alphabet.");
//                 }
//         }
//
//     }
//
//     public static void main(String[] args) {
//         new FrameDemo();
//     }
// }


//
////Wap to create a frame with 3 buttons (red,green,blue)when button is pressed change background colour of frame acording to pressed button
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//public class Lab3 {
//    public static class FrameDemo extends JFrame implements ActionListener {
//        JLabel color;
//        JButton red, blue, green;
//        FrameDemo() {
//         color=new JLabel("CHANGE BACKGROUND COLOUR :");
//         red = new JButton("RED");
//         blue = new JButton("BLUE");
//         green= new JButton("GREEN");
//         setLayout(new GridLayout(1,2));
//         add(color);
//         add(red); add(blue);add(green);
//            blue.addActionListener(this);
//            red.addActionListener(this);
//            green.addActionListener(this);
//            setSize(400, 400);
//            setTitle("MenuFrame");
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//            setVisible(true);
//        }
//
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == blue)
//                this.getContentPane().setBackground(Color.BLUE);
//            else if (e.getSource() == red)
//                this.getContentPane().setBackground(Color.RED);
//            else if (e.getSource() == green)
//                this.getContentPane().setBackground(Color.GREEN);
//        }
//    }
//
//    public static void main(String[] args) {
//        new FrameDemo();
//    }
//}