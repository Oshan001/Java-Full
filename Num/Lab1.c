// //bisection and False Position methods for solution of nonlinear equations
//bisection method
/*
#include <stdio.h>
#include <math.h>
#define tol 0.001 //tolerance
float f(float x) {
    return x*x-x-1; //function to find root
}
int main() {
    float x0, x1,f1,f2,f0,x2;
    loop:
    printf("enter the value of X0,X1 :\n");
    scanf("%f %f", &x0, &x1);
    f0=f(x0); //function value at x0
    f1=f(x1); //function value at x1
    if(f0*f1>0) { //if function values at x0 and x1 are same sign
        printf("Invalid input\n");
        goto loop; //prompt user for input again

    }\
    else{
        printf("\n initial guess bracket the root\n" );
    }
    printf("iteration\tX0\tX1\tX2\tF(X2)\n"); //print header for table
    printf("--------------------------------------------------------------\n");
    int iteration=0; //iteration counter
    do{
        x2=(x0+x1)/2; //midpoint of x0 and x1
        f2=f(x2); //function value at midpoint
        printf("%d\t%f\t%f\t%f\t%f\n", iteration, x0, x1, x2, fabs(f2)); //print iteration number and values
        iteration++; //increment iteration number
      if(f2 == 0)
      break;
      else if (f0*f2<0)
       x1=x2;
       else
       x0=x2;
    }while(fabs(f2)>tol); //loop until the function value is within tolerance
    printf("\nRoot is: %f\n", x2); //print root
    return 0;
      }
*/


// //false position method
// #include <stdio.h>
// #include <math.h>
// #define tol 0.001 //tolerance
// float f(float x) {
//     return x*x-x-1; //function to find root
// }
// int main() {

//     float x0, x1,f1,f2,f0,x2;
//     loop:
//     printf("enter the value of X0,X1 :\n");
//     scanf("%f %f", &x0, &x1);
//     f0=f(x0); //function value at x0
//     f1=f(x1); //function value at x1
//     if(f0*f1>0) { //if function values at x0 and x1 are same sign
//         printf("Invalid input\n");
//         goto loop; //prompt user for input again

//     }
//     else{
//         printf("\n initial guess bracket the root\n" );
//     }
//     printf("iteration\tX0\tX1\tX2\tF(X2)\n"); //print header for table
//     printf("--------------------------------------------------------------\n");
//     int iteration=0; //iteration counter
//     do{
//         x2=(x0 * f(x1) - x1 * f(x0)) / (f(x1) - f(x0)); //false position formula
//         f2=f(x2); //function value at midpoint
//         printf("%d\t%f\t%f\t%f\t%f\n", iteration, x0, x1, x2, fabs(f2)); //print iteration number and values
//         iteration++; //increment iteration number
//       if(f2 == 0)
//       break;
//       else if (f0*f2<0)
//        x1=x2;
//        else
//        x0=x2;
//     }while(fabs(f2)>tol); //loop until the function value is within tolerance
//     printf("\nRoot is: %f\n", x2); //print root
//     return 0;
//       }


//false position method
// function x-pow(e,-x)
// #include <stdio.h>
// #include <math.h>
// #define tol 0.001 //tolerance
// float f(float x) {
//     return x-exp(-x); //function to find root
// }
// int main() {

//     float x0, x1,f1,f2,f0,x2;
//     loop:
//     printf("enter the value of X0,X1 :\n");
//     scanf("%f %f", &x0, &x1);
//     f0=f(x0); //function value at x0
//     f1=f(x1); //function value at x1
//     if(f0*f1>0) { //if function values at x0 and x1 are same sign
//         printf("Invalid input\n");
//         goto loop; //prompt user for input again

//     }
//     else{
//         printf("\n initial guess bracket the root\n" );
//     }
//     printf("iteration\tX0\tX1\tX2\tF(X2)\n"); //print header for table
//     printf("--------------------------------------------------------------\n");
//     int iteration=0; //iteration counter
//     do{
//         x2=(x0 * f(x1) - x1 * f(x0)) / (f(x1) - f(x0)); //false position formula
//         f2=f(x2); //function value at midpoint
//         printf("%d\t%f\t%f\t%f\t%f\n", iteration, x0, x1, x2, fabs(f2)); //print iteration number and values
//         iteration++; //increment iteration number
//       if(f2 == 0)
//       break;
//       else if (f0*f2<0)
//        x1=x2;
//        else
//        x0=x2;
//     }while(fabs(f2)>tol); //loop until the function value is within tolerance
//     printf("\nRoot is: %f\n", x2); //print root
//     return 0;
//       }

//false position method
// function x *pow(e,x)-cosx
// #include <stdio.h>
// #include <math.h>
// #define tol 0.001 //tolerance
// float f(float x) {
//     return x*exp(x)-cos(x); //function to find root
// }
// int main() {

//     float x0, x1,f1,f2,f0,x2;
//     loop:
//     printf("enter the value of X0,X1 :\n");
//     scanf("%f %f", &x0, &x1);
//     f0=f(x0); //function value at x0
//     f1=f(x1); //function value at x1
//     if(f0*f1>0) { //if function values at x0 and x1 are same sign
//         printf("Invalid input\n");
//         goto loop; //prompt user for input again

//     }
//     else{
//         printf("\n initial guess bracket the root\n" );
//     }
//     printf("iteration\tX0\tX1\tX2\tF(X2)\n"); //print header for table
//     printf("--------------------------------------------------------------\n");
//     int iteration=0; //iteration counter
//     do{
//         x2=(x0 * f(x1) - x1 * f(x0)) / (f(x1) - f(x0)); //false position formula
//         f2=f(x2); //function value at midpoint
//         printf("%d\t%f\t%f\t%f\t%f\n", iteration, x0, x1, x2, fabs(f2)); //print iteration number and values
//         iteration++; //increment iteration number
//       if(f2 == 0)
//       break;
//       else if (f0*f2<0)
//        x1=x2;
//        else
//        x0=x2;
//     }while(fabs(f2)>tol); //loop until the function value is within tolerance
//     printf("\nRoot is: %f\n", x2); //print root
//     return 0;
//       }


//false position method
// function x*e ^(x)-cos(x)


// #include <stdio.h>
// #include <math.h>
// #define tol 0.001 //tolerance
// float f(float x) {
//     return x*exp(x)-cos(x); //function to find root
// }
// int main() {

//     float x0, x1,f1,f2,f0,x2;
//     loop:
//     printf("enter the value of X0,X1 :\n");
//     scanf("%f %f", &x0, &x1);
//     f0=f(x0); //function value at x0
//     f1=f(x1); //function value at x1
//     if(f0*f1>0) { //if function values at x0 and x1 are same sign
//         printf("Invalid input\n");
//         goto loop; //prompt user for input again

//     }
//     else{
//         printf("\n initial guess bracket the root\n" );
//     }
//     printf("iteration\tX0\tX1\tX2\tF(X2)\n"); //print header for table
//     printf("--------------------------------------------------------------\n");
//     int iteration=0; //iteration counter
//     do{
//         x2=(x0 * f(x1) - x1 * f(x0)) / (f(x1) - f(x0)); //false position formula
//         f2=f(x2); //function value at midpoint
//         printf("%d\t%f\t%f\t%f\t%f\n", iteration, x0, x1, x2, fabs(f2)); //print iteration number and values
//         iteration++; //increment iteration number
//       if(f2 == 0)
//       break;
//       else if (f0*f2<0)
//        x1=x2;
//        else
//        x0=x2;
//     }while(fabs(f2)>tol); //loop until the function value is within tolerance
//     printf("\nRoot is: %f\n", x2); //print root
//     return 0;
//       }


/*
      #include <stdio.h>
#include <math.h>
#define tol 0.001 //tolerance
float f(float x) {
    return  x * log10(x) - 1.2;
 //function to find root
}
int main() {

    float x0, x1,f1,f2,f0,x2;
    loop:
    printf("enter the value of X0,X1 :\n");
    scanf("%f %f", &x0, &x1);
    f0=f(x0); //function value at x0
    f1=f(x1); //function value at x1
    if(f0*f1>0) { //if function values at x0 and x1 are same sign
        printf("Invalid input\n");
        goto loop; //prompt user for input again

    }
    else{
        printf("\n initial guess bracket the root\n" );
    }
    printf("iteration\tX0\tX1\tX2\tF(X2)\n"); //print header for table
    printf("--------------------------------------------------------------\n");
    int iteration=0; //iteration counter
    do{
        x2=(x0 * f(x1) - x1 * f(x0)) / (f(x1) - f(x0)); //false position formula
        f2=f(x2); //function value at midpoint
        printf("%d\t%f\t%f\t%f\t%f\n", iteration, x0, x1, x2, fabs(f2)); //print iteration number and values
        iteration++; //increment iteration number
      if(f2 == 0)
      break;
      else if (f0*f2<0)
       x1=x2;
       else
       x0=x2;
    }while(fabs(f2)>tol); //loop until the function value is within tolerance
    printf("\nRoot is: %f\n", x2); //print root
    return 0;
      }*/


      //false position method
#include <stdio.h>
#include <math.h>
#define tol 0.001 //tolerance
float f(float x) {
    return cos(x)+(pow(exp(x),x))+(x*x)-3; //function to find root
}
int main() {

    float x0, x1,f1,f2,f0,x2;
    loop:
    printf("enter the value of X0,X1 :\n");
    scanf("%f %f", &x0, &x1);
    f0=f(x0); //function value at x0
    f1=f(x1); //function value at x1
    if(f0*f1>0) { //if function values at x0 and x1 are same sign
        printf("Invalid input\n");
        goto loop; //prompt user for input again

    }
    else{
        printf("\n initial guess bracket the root\n" );
    }
    printf("iteration\tX0\tX1\tX2\tF(X2)\n"); //print header for table
    printf("--------------------------------------------------------------\n");
    int iteration=0; //iteration counter
    do{
        x2=(x0 * f(x1) - x1 * f(x0)) / (f(x1) - f(x0)); //false position formula
        f2=f(x2); //function value at midpoint
        printf("%d\t%f\t%f\t%f\t%f\n", iteration, x0, x1, x2, fabs(f2)); //print iteration number and values
        iteration++; //increment iteration number
      if(f2 == 0)
      break;
      else if (f0*f2<0)
       x1=x2;
       else
       x0=x2;
    }while(fabs(f2)>tol); //loop until the function value is within tolerance
    printf("\nRoot is: %f\n", x2); //print root
    return 0;
      }
