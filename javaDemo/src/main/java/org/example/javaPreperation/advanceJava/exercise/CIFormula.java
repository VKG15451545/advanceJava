package org.example.javaPreperation.advanceJava.exercise;

import java.util.Scanner;

public class CIFormula {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Compound Interest:");
        double principleAmount;
        double rate;
        int timesCompounded;
        int years;
        double amount;
        System.out.println("Enter the principle amount: ");
        principleAmount = sc.nextDouble();
        System.out.println("enter the interest rate:");
        rate = sc.nextDouble()/100;
        System.out.println("Enter the number of times compounded per year:");
        timesCompounded = sc.nextInt();
        System.out.println("enter the years: ");
        years = sc.nextInt();
        amount = principleAmount *Math.pow(1+rate/timesCompounded,timesCompounded*years);
        System.out.printf("the total amount after %d years is $%.2f",years,amount);
        sc.close();
    }
}
