package org.example.javaPreperation.advanceJava.variable;

import java.util.Scanner;

public class UserInput {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
        System.out.println("good morning "+name);
    }
}
