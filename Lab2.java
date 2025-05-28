////LAB2 Group A
////WAP to show Exeception Handling
//import  java.util.*;
//public class Lab2 {
//
//    public static void main(String[] var0) {
//        System.out.println("Enter your Age :");
//        Scanner sc = new Scanner(System.in);
//        int age = sc.nextInt();
//        try {
//            if (age <18) {
//                throw new ArithmeticException();
//            }
//            System.out.println("id :");
//            int C_id = sc.nextInt();
//            sc.nextLine();
//
//            System.out.println("name :");
//            String name = sc.nextLine();
//            System.out.println("gender :");
//            String Ge = sc.nextLine();
//            System.out.println("|----------Citizenship Car----------|");
//            System.out.printf("Name : %s \nAge : %d \nCit_id :%d \nSex: %s \n",name,age,C_id,Ge);
//        }
//          catch(ArithmeticException e){
//                System.out.println("you are under age");
//            }
//        finally{
//            System.out.print("\n\n");
//            System.out.println("You have cerated Citizenship card sucessfully");
//        }
//
//
//    }
//}
//
//interface Bank {
//    void deposite(float balance);
//    void withDraw(float Amount);
//}
//class Saving implements Bank{
//    private float prebalance =100000;
//    public void deposite(float balance) {
//        prebalance += balance;
//        System.out.println(" your new balance is ="+prebalance);
//
//    }
//    public void withDraw(float Amount){
//        if(Amount > prebalance){
//            System.out.println("Insufficient balance! \n your balance is ="+prebalance);
//        }else{
//            prebalance -= Amount;
//        }
//        System.out.println("your balance is ="+prebalance);
//
//    }
//
//    }
//
//public class Lab2 {
//    public static void main(String[] args) {  // Corrected main method signature
//        Saving acc = new Saving();
//        acc.deposite(1000);  // Corrected method call with output
//        acc.withDraw(500);    // Added withdrawal example
//    }
//}


////LAB2 Group B
//Number Guessing Game
//import java.util.*;
//public class Lab2 {
//    public static void main(String[] args) {
//        List<Integer> myList = new ArrayList<>();
//        Random rand = new Random();
//        int rand1 = rand.nextInt(100)+1;
//        //System.out.println(rand1);
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("Enter your Guess 1-100 :");
//            int choice = sc.nextInt();
//            if (rand1 == choice) {
//                System.out.println("You Guess is correct");
//                break;
//            }
//            else if (rand1 <choice) {
//                System.out.println("You Number is Greater");
//            } else {
//                System.out.println("You Number is Smaller");
//            }
//            myList.add(choice);
//
//        }
//        System.out.println(myList);
//    }
//}


//
//  //Game Rock Sicisor Paper
//import java.util.*;
//public class Lab2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] gameChoices = {"Rock", "Paper", "Scissors"};
//        while (true) {
//            Random random = new Random();
//
//            int computerChoice = random.nextInt(gameChoices.length);
//
//            System.out.println("Enter your choice:\n 1 for Rock\n 2 for Paper\n 3 for Scissors");
//            int userChoice = sc.nextInt() - 1; // Convert user input to match array indexing
//
//            if (userChoice < 0 || userChoice >= gameChoices.length) {
//                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
//                return;
//            }
//
//            System.out.printf("You chose %s, Computer chose %s.\n", gameChoices[userChoice], gameChoices[computerChoice]);
//
//            if (userChoice == computerChoice) {
//                System.out.println("It's a tie! 🤝");
//            } else if ((userChoice == 0 && computerChoice == 2) ||
//                    (userChoice == 1 && computerChoice == 0) ||
//                    (userChoice == 2 && computerChoice == 1)) {
//                System.out.println("You win! 🎉");
//            } else {
//                System.out.println("You lose! 😢");
//            }
//        }
//    }
//}
//


