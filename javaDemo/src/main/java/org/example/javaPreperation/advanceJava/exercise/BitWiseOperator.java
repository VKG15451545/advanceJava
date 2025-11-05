package org.example.javaPreperation.advanceJava.exercise;

import java.util.Scanner;

public class BitWiseOperator {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("bitwise add enter num 1:");
        int a = sc.nextInt();
        System.out.println("enter nume 2");
        int b = sc.nextInt();
        System.out.printf("bitwise and of %d and %d is %d\n",a,b,a&b);
        System.out.printf("bitwise or of %d and %d is %d\n",a,b,a|b);
        System.out.printf("bitwise xor of %d and %d is %d\n",a,b,a^b);
        System.out.printf("bitwise complement of %d is %d\n",a,~a);
        System.out.printf("left shift of %d is %d\n",a,a<<1);
        System.out.printf("right shift of %d is %d\n",a,a>>1);
        String evenOrOdd = (a & 1) == 1 ? "odd" : "even";
        System.out.printf("%d is %s number",a,evenOrOdd);

    }
}
