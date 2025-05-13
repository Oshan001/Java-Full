import java.util.Scanner;
public class Lab1_A {
    public static void main(String[] args) {
//         odd num to range O ot Nth
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range :");
        int range = sc.nextInt() ;
        int i,j;
        System.out.printf("The Odd Number To Range 0 to %d is :\n",range);
        for(i=1;i<=range-1;i=i+2){
            System.out.println(i);
        }
        System.out.println("\n__________________________________________________");


//-----------------------------------------------------------//





        //to print patten
//         1)    * * * * *          |  2)      * * * * *      | 3)    *
//               * * * *            |          *       *      |       * *
//               * * *              |          *       *      |       * * *
//               * *                |          *       *      |       * * * *
//               *                  |          * * * * *      |       * * * * *


                System.out.println("1)");
        for (i=4;i>=0;i--){
            for (j=0;j<=i;j++){
                System.out.print("*\t");
            }
            System.out.print("\n");
        }
        System.out.println("__________________________________________________");



// -----------------------------------------------------------//


       System.out.println("2)");
        for (i=0;i< 5;i++) {
            for (j = 0; j < 5; j++) {
                if(j==0 || i==0 || j==4 || i==4)
                    System.out.print("*\t");
                else
                    System.out.print("\t");

            }
            System.out.print("\n");
        }
       System.out.println("__________________________________________________");



//-----------------------------------------------------------//



       System.out.println("3)");
        for (i=0;i< 5;i++) {
            for (j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.println("__________________________________________________");



//-----------------------------------------------------------//


    }
}
