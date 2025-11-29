package org.example.javaPreperation.dsa;

import org.example.javaPreperation.dsa.questions.AllQuestions;

import java.util.Scanner;

public class Solutions {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AllQuestions allQuestions = new AllQuestions();
        allQuestions.printAllQuestions();
        System.out.println("select Question No.");
        int qNo = sc.nextInt();
        System.out.println(allQuestions.questionSelector(sc,qNo));
    }
}
