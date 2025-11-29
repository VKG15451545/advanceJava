package org.example.javaPreperation.dsa.questions;

import java.util.Scanner;

public class AllQuestions {
    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public int questionNo;
    public void printAllQuestions(){
        System.out.println("1.GCD");
    }
    public Object questionSelector(Scanner sc,int n){
        if(n==1){
            System.out.println("enter first No: ");
            int a = sc.nextInt();
            System.out.println("enter Second No: ");
            int b = sc.nextInt();
            return GCD(a,b);
        }else{
            return "Please Select Valid Question Number";
        }
    }
    public int GCD(int a,int b){
        if(a==0) return b;
        System.out.println("a:"+a+",b:"+b+",b%a:"+b%a);
        return GCD(a,b%a);
    }
}
