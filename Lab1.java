//LAB1 group A
//import java.util.Scanner;
//public class Lab1 {
//    public static void main(String[] args) {
////         odd num to range O ot Nth
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the range :");
//        int range = sc.nextInt() ;
//        int i,j;
//        System.out.printf("The Odd Number To Range 0 to %d is :\n",range);
//        for(i=1;i<=range-1;i=i+2){
//            System.out.println(i);
//        }
//        System.out.println("\n__________________________________________________");
//
//
////-----------------------------------------------------------//
//
//
//
//
//
//        //to print patten
////         1)    * * * * *          |  2)      * * * * *      | 3)    *
////               * * * *            |          *       *      |       * *
////               * * *              |          *       *      |       * * *
////               * *                |          *       *      |       * * * *
////               *                  |          * * * * *      |       * * * * *
//
//
//        System.out.println("1)");
//        for (i=4;i>=0;i--){
//            for (j=0;j<=i;j++){
//                System.out.print("*\t");
//            }
//            System.out.print("\n");
//        }
//        System.out.println("__________________________________________________");
//
//
//
//// -----------------------------------------------------------//
//
//
//        System.out.println("2)");
//        for (i=0;i< 5;i++) {
//            for (j = 0; j < 5; j++) {
//                if(j==0 || i==0 || j==4 || i==4)
//                    System.out.print("*\t");
//                else
//                    System.out.print("\t");
//
//            }
//            System.out.print("\n");
//        }
//        System.out.println("__________________________________________________");
//
//
//
////-----------------------------------------------------------//
//
//
//
//        System.out.println("3)");
//        for (i=0;i< 5;i++) {
//            for (j = 0; j <= i; j++) {
//                System.out.print("*");
//            }
//            System.out.print("\n");
//        }
//        System.out.println("__________________________________________________");
//
//
//
////-----------------------------------------------------------//
//
//
//    }
//}


////LAB1 Group B
//import java.util.Scanner;
//import java.util.Arrays;
//public class Lab1 {
//    public static void main(String[] args) {
// //WAP to to sort an arrya
//   int[] a ={10,50,5,100,12};
//   Arrays.sort(a);
//       System.out.println(Arrays.toString(a));
//        System.out.println("--------------------------------------------------------------------------------------------");
//
//
//
//
//        // wap to search array
//        int aa[]={10,50,5,100,12};
//        Scanner sc= new Scanner(System.in);
//
//            System.out.println("Enter The Data To Be Search In Array :");
//            int b = sc.nextInt();
//            int i;
//            for (i = 0; i <= aa.length - 1; i++) {
//                if (b == aa[i]) {
//                    System.out.printf("The Array %d is Sucesfully found at index %d", b, i);
//                    break;
//                }
//                if (i == aa.length - 1) {
//                    System.out.printf("The Array %d is not found", b);
//                }
//
//            }


////sort logic
//        int[] a1 = {10, 50, 5, 100, 12};
//        int  i,temp, j;
//        for (i = 0; i < a1.length; i++) {
//            for (j = 0; j < i; j++) {
//                if (a1[i] < a1[j]) {
//                    temp = a1[i];
//                    a1[i] = a1[j];
//                    a1[j] = temp;
//                }
//
//            }
//        }
//        // to print array
//        System.out.print("[ ");
//        for (i = 0; i < a1.length; i++) System.out.print(a1[i] + " ");
//        System.out.print("]");
//
//    }
//}




