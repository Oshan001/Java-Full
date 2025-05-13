
import java.util.Scanner;
public class Lab1_B {
    public static void main(String[] args) {
//         even num to range O ot Nth
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range :");
        int range = sc.nextInt() ;
        int i,j;
        System.out.printf("The Odd Number To Range 0 to %d is :\n",range);
        for(i=0;i<=range;i=i+2){
            System.out.println(i);
        }



    }
}