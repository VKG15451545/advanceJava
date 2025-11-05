package org.example.javaPreperation.advanceJava.operator;

import java.util.Scanner;

public class Assignment {
    static void main(String[] args) {
        int myInt = 9;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter value of a:");
        int a = sc.nextInt();
        System.out.println("enter value of b:");
        int b = sc.nextInt();
        System.out.printf("a: %d,b: %d",a,b);
        System.out.println("after swapping");
        int c = a;
        a = b;
        b = c;
        System.out.printf("a: %d,b: %d",a,b);
        // Arithmetic Operator :
        System.out.println(8-7*3);  // BODMAS (left->right)
        //shortHand Operator
        int d = 0;
        d += 3;
        System.out.println(d);
        // Unary Operator(-,++x(preIncrement),x++(postIncrement),--)
        // Relational Operator( <,>,<=,>=,==,!=)
        // Operator Precendence
        /*
           Unary  (Right to left)
           Assignment( Right to Left)
           Ternary ( ?: Right to Left)
         */

        /*
        Binary Number System:
            10110101010110  : 2+4+16

       BitWise Operator:
             1 ^ 0 : 1
             1 ^ 1 : 0
             0 ^ 0 : 0
             0 ^ 1 : 1
             100 <<  -->left sift 1000
         */



    }
}
